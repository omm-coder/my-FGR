package org.omm.config;

import org.omm.interceptor.ProcessingTimeLogInterceptor;
import org.omm.model.Product;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;
import org.springframework.web.util.UrlPathHelper;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Locale;

@Configuration
@ComponentScan("org.omm")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resourceViewResolver =
                new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/WEB-INF/views/");
        resourceViewResolver.setSuffix(".jsp");
        resourceViewResolver.setViewClass(JstlView.class);
        return resourceViewResolver;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource managerDataSource =
                new DriverManagerDataSource();
        managerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        managerDataSource.setUrl("jdbc:mysql://localhost:3306/store");
        managerDataSource.setUsername("root");
        managerDataSource.setPassword("asmac");

        return managerDataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate parameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource bundleMessageSource =
                new ResourceBundleMessageSource();
        bundleMessageSource.setBasename("messages");
        return bundleMessageSource;
    }
    @Bean
    public LocalValidatorFactoryBean getFactoryValidator() {
        LocalValidatorFactoryBean validatorFactoryBean =
                new LocalValidatorFactoryBean();
        validatorFactoryBean.setValidationMessageSource(messageSource());
        return validatorFactoryBean;
    }

    @Override
    public Validator getValidator() {
        return getFactoryValidator();
    }

    @Bean
    public MappingJackson2JsonView jsonView() {
        MappingJackson2JsonView jackson2JsonView =
                new MappingJackson2JsonView();
        jackson2JsonView.setPrettyPrint(true);
        return jackson2JsonView;
    }
    @Bean
    public MarshallingView xmlView() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Product.class);
        MarshallingView marshallingView = new MarshallingView();
        marshallingView.setMarshaller(marshaller);
        return marshallingView;
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver
            (ContentNegotiationManager manger) {
        ContentNegotiatingViewResolver resolver =
                new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manger);

        ArrayList<View> views = new ArrayList<>();
        views.add(jsonView());
        views.add(xmlView());
        resolver.setDefaultViews(views);
        return resolver;
    }
    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver =
                new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH);
       return sessionLocaleResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ProcessingTimeLogInterceptor());
        LocaleChangeInterceptor changeInterceptor =
                new LocaleChangeInterceptor();
        changeInterceptor.setParamName("lang");
        registry.addInterceptor(changeInterceptor);


    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/res/**")
                .addResourceLocations("/WEB-INF/static/images/","WEB-INF/static/js/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }



}
