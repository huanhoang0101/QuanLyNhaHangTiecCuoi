/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmh.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hmh.handlers.LoginHandler;
import com.hmh.handlers.LogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author HoanTran
 */
@Configuration
@EnableTransactionManagement
@EnableWebSecurity
@ComponentScan(basePackages = {
    "com.hmh.controllers",
    "com.hmh.repository",
    "com.hmh.service",
    "com.hmh.handlers"})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private LoginHandler loginHandler;
    @Autowired
    private LogoutHandler logoutHanlder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary c = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dnrpggpn0",
                "api_key", "719655946352422",
                "api_secret", "5L0sUTPsvYsPNaDNKIXwYP-39sI",
                "secure", true
        ));

        return c;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().usernameParameter("username").passwordParameter("password");

        http.formLogin().successHandler(loginHandler);
        http.logout().logoutSuccessHandler(logoutHanlder);

        http.csrf().disable();
    }
}
