//package com.ruchira.configServer;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
///**
// * Created by Ruchira on 10/22/2020.
// */
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//    /**
//     * Setting spring security
//     * Here we permit all swagger urls to access service without any authentication
//     *
//     * @param http Http Security instance
//     * @throws Exception Exception
//     */
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers().permitAll()
//                //.antMatchers( "/","/**","/**/**","/**/**/**","/**/**/**/**").permitAll()
//                .anyRequest().authenticated();
//    }
//}
