package com.diploma.project.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	@Bean
	@Qualifier("favoritesWebClient")
	public WebClient favoritesWebClient() {
		return WebClient.builder()
				.baseUrl("http://localhost:8092") // FavoritesService
				.build();
	}
}
