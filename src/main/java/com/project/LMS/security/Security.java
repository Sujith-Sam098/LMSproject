package com.project.LMS.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security {

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFill(HttpSecurity http) throws Exception
    {
         return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth->
                {
                    auth.requestMatchers("/users/register","/user/login)").permitAll();
                    auth.requestMatchers("/admins/**").hasRole("ADMIN");
                    auth.requestMatchers("/professors/**").hasRole("PROFESSOR");
                    auth.requestMatchers("/courses/**").authenticated();
                    auth.anyRequest().denyAll();
                })
                 .formLogin(form -> form
                         .loginPage("/users/login") // Custom login page for all users
                         .defaultSuccessUrl("/users/home", true) // Redirect to courses list after login
                         .permitAll() // Allow everyone to see the login page
                 )
                 .oauth2Login(oauth -> oauth
                         .loginPage("/users/login") // Use the same login page for OAuth2
                         .defaultSuccessUrl("/users/home", true) // Redirect to courses list after successful OAuth2 login
                         .failureUrl("/users/login?error=true") // Redirect back to login page on failure
                 )
                 .logout(logout -> logout
                         .logoutUrl("/logout")
                         .logoutSuccessUrl("/users/login?logout") // Redirect to login page after logout
                 )
                 .build();
    }
}
