package org.example.favoriteservice.feingclients;

import lombok.AllArgsConstructor;
import org.example.favoriteservice.dto.MarketplaceServiceDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@AllArgsConstructor
public class MarketplaceServiceClient {

	private final WebClient webClient;

	private final String baseUrl = "http://localhost:8090/api/service";

	public MarketplaceServiceDTO findById(Long serviceId) {
		return webClient.get()
				.uri(baseUrl + "/" + serviceId)
				.retrieve()
				.bodyToMono(MarketplaceServiceDTO.class)
				.block();
	}
}