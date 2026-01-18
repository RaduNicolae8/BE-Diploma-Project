package com.diploma.project.auth.config;

import com.diploma.project.auth.AuthConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AuthClientConfig {
    @Bean
    WebClient authWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl(AuthConstants.urlToAuthService) // the other API port
                .build();
    }
}
