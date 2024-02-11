package com.alpesh.springbootjavamysqlapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Boot component based security configuration class for local profile.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@Profile("local")
public class LocalSecurityConfiguration  {
    // Configure users for this application.
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {

        // Admin user
        UserDetails adminUser = User.withUsername("alpesh").password(encoder.encode("1209")).roles("ADMIN","USER").build();
        // Generic user
        UserDetails generalUser = User.withUsername("aarav").password(encoder.encode("2810")).roles("USER").build();
        // Aggregate users and return In memory user Details manager.
        return new InMemoryUserDetailsManager(adminUser,generalUser);
    }

    // Configure http security for endpoints based upon user roles.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf().disable().authorizeHttpRequests().requestMatchers("/api/").permitAll().and().
                authorizeHttpRequests().requestMatchers("/api/welcome").permitAll().and().
                authorizeHttpRequests().requestMatchers("/api/user/**").authenticated().and().
                authorizeHttpRequests().requestMatchers("/api/admin/**").authenticated().and().formLogin().and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
