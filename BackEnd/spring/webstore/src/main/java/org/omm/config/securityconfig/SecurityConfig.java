package org.omm.config.securityconfig;

import org.jboss.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public static final Logger LOG
            = Logger.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers("/addProduct","/saveProduct").hasRole("ADMIN");
                    authorize.requestMatchers("/products","/product","/products/filter")
                            .hasAnyRole("USER","ADMIN");
                    authorize.requestMatchers("/","/WEB-INF/views/**").permitAll();
                    authorize.anyRequest().authenticated();

                })
                .formLogin(customizer ->{
                    customizer.loginPage("/login")
                            .loginProcessingUrl("/login")
                            .usernameParameter("userName")
                            .passwordParameter("pass")
                            .defaultSuccessUrl("/products", true)
                            .permitAll();
                })
                .logout(LogoutConfigurer::getLogoutSuccessHandler)
                .exceptionHandling(exception -> {
                    exception.accessDeniedHandler(customAccessDeniedHandler());
                })
//                .formLogin(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public AccessDeniedHandler customAccessDeniedHandler() {

        return ((request, response, accessDeniedException) -> {
            Authentication auth
                    = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null) {
                LOG.warn("User: " + auth.getName()
                        + " attempted to access the protected URL: "
                        + request.getRequestURI());
            }

            response.sendRedirect(request.getContextPath() + "/accessDenied");
        });
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User
                .withUsername("user")
                .password("{noop}user")
                .roles("USER").build();
        UserDetails admin = User
                .withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user,admin);
    }

}
