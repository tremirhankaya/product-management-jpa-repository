package com.emirhan.product_crud_jpa_repo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
                .roles("EMPLOYEE,MANAGER")
                .build();

        UserDetails ece= User.builder()
                .username("ece")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();


        return new InMemoryUserDetailsManager(ahmet,emirhan,ece);
    }
    
}
