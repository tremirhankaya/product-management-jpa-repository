package com.emirhan.product_crud_jpa_repo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {


    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails ahmet= User.builder()
                .username("ahmet")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails emirhan= User.builder()
                .username("emirhan")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails ece= User.builder()
                .username("ece")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        UserDetails admin= User.builder()
                .username("admin")
                .password("{noop}test123")
                .roles("ADMIN","MANAGER","EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(ahmet,emirhan,ece,admin);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.POST, "/api/products").hasRole("MANAGER")

                        .requestMatchers(HttpMethod.PUT, "/api/products/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/products/**").hasRole("EMPLOYEE")

                        .anyRequest().authenticated()
        );

        http.httpBasic(withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
