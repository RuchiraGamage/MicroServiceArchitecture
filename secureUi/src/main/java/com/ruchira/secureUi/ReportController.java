package com.ruchira.secureUi;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ruchira on 10/25/2020.
 */
@Controller
@EnableOAuth2Sso
public class ReportController extends WebSecurityConfigurerAdapter{

    @RequestMapping("/")
    public String loadHome(){
        return "home";
    }

    @RequestMapping("/user")
    public String userPage(){
        return "user";
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/","/login")
                    .permitAll()
                .anyRequest()
                    .authenticated();
    }
}
