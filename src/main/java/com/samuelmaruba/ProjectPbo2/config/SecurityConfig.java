/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.samuelmaruba.ProjectPbo2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author samue
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/").permitAll()
                                .requestMatchers("/register/**").permitAll()
                                .requestMatchers("/users").hasRole("ADMIN")
                                .requestMatchers("/admin/daerahs").hasAnyRole("ADMIN","USER")
                                .requestMatchers("/admin/daerahs/add").hasRole("ADMIN")
                                .requestMatchers("/admin/anggotas").hasAnyRole("ADMIN","USER")
                                .requestMatchers("/admin/anggotas/add").hasRole("ADMIN")
                                .requestMatchers("/admin/kegiatans").hasAnyRole("ADMIN","USER")
                                .requestMatchers("/admin/kegiatans/add").hasRole("ADMIN")
                                .requestMatchers("/admin/daerahs/update/{id}").hasAnyRole("ADMIN")
                                .requestMatchers("/admin/daerahs/delete/{id}").hasRole("ADMIN")
                                .requestMatchers("/css/style.css").permitAll()
                                .requestMatchers("/js/script.js").permitAll()
                                .requestMatchers("/css/imager/**").permitAll()                                .anyRequest().authenticated()
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/index")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
