package org.example.favoriteservice.feingclients;

import lombok.AllArgsConstructor;
import org.example.favoriteservice.dto.MarketplaceUserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@AllArgsConstructor
public class MarketplaceUserClient {

	private final WebClient webClient;

	private final String baseUrl = "http://localhost:8090/api/marketplace-user";

	public MarketplaceUserDTO findById(Long userId) {
		return webClient.get()
				.uri(baseUrl + "/" + userId)
				.retrieve()
				.bodyToMono(MarketplaceUserDTO.class)
				.block();
	}
}
