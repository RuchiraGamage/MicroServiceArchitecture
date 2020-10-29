package com.ruchira.SecureAuthServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@RestController
public class SecureAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecureAuthServerApplication.class, args);
    }


    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}