package com.ruchira.SecureAuthServer;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;

/**
 * Created by Ruchira on 10/27/2020.
 * use to create credentials for log in
 * we can manage different authentication stores
 * not like embed credentials in configuration file
 * this is in memory authentication store
 */
@Configuration
public class ServiceConfig extends GlobalAuthenticationConfigurerAdapter {

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("agoldberg").password("pass1").roles("USER").and()
                .withUser("bgoldberg").password("pass2").roles("USER", "OPERATOR");
    }

}

