package com.ruchira.SecureCli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

import java.util.Arrays;

@SpringBootApplication
public class SecureCliApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SecureCliApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Starting cron job");

        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
        resourceDetails.setAccessTokenUri("http://localhost:9000/services/oauth/token");

        //must be a valid scope or get an error; if empty, get all scopes (default); better to ask for one
        resourceDetails.setScope(Arrays.asList("toll_read"));

        resourceDetails.setGrantType("password");

        //must be valid client id or get an error
        resourceDetails.setClientId("secureApplication");
        resourceDetails.setClientSecret("secureApplicationsecret");

        //diff user results in diff authorities/roles coming out; preauth on roles fails for adam, works for barry
        resourceDetails.setUsername("agoldberg");
        resourceDetails.setPassword("pass1");

        OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails);
        //could also get scopes: template.getAccessToken().getScope()
        String token =  template.getAccessToken().toString();//.getValue();

        System.out.println("Token: " + token);

        String s = template.getForObject("http://localhost:9001/services/tolldata", String.class);

        System.out.println("Result: " + s);
    }
}
