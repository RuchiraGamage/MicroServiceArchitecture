package com.ruchira.secureUi;

import com.ruchira.secureUi.model.TollUsage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * Created by Ruchira on 10/25/2020.
 */
@Controller
@EnableOAuth2Sso
public class ReportController extends WebSecurityConfigurerAdapter {

    @Qualifier("oauth2ClientContext")
    @Autowired
    private OAuth2ClientContext auth2ClientContext;

    @Autowired
    private OAuth2RestTemplate auth2RestTemplate;

    @RequestMapping("/")
    public String loadHome() {
        return "home";
    }

    @RequestMapping("/user")
    public String userPage() {
        return "user";
    }

    @RequestMapping("/reports")
    public String loadReports(Model model) {

        OAuth2AccessToken token = auth2ClientContext.getAccessToken();
        System.out.println("token : " + token.getValue());

        ResponseEntity<ArrayList<TollUsage>> tolls = auth2RestTemplate
                .exchange("http://localhost:9001/services/tolldata"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<ArrayList<TollUsage>>(){});

        model.addAttribute("tolls",tolls.getBody());

        return "reports";
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}
