package org.omm.config.secconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/user").hasAnyRole("ADMIN","USER");
                    auth.requestMatchers("/admin").hasRole("ADMIN");
                    auth.requestMatchers("/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin(customizer -> {
                    customizer.loginPage("/userLogin")
                            .loginProcessingUrl("/processLogin")
                            .usernameParameter("userName")
                            .passwordParameter("pass")
                            .defaultSuccessUrl("/", true)
                            .permitAll();
                })
//                .formLogin(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);
        return httpSecurity.build();
    }

    @Bean
    public InMemoryUserDetailsManager detailsService() {
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(users.username("user").password("password")
//                .roles("USER").build());
//        manager.createUser(users.username("admin").password("password")
//                .roles("ADMIN").build());
        return new InMemoryUserDetailsManager();
    }
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//        return configuration.getAuthenticationManager();
//    }
}
