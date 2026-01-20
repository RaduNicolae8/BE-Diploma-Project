package com.diploma.project.favoriteserviceclient;

import com.diploma.project.dto.MarketplaceServiceDTO;
import com.diploma.project.dto.StarredServiceDTO;
import com.diploma.project.security.HeartRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class FavoritesServiceClient {

	private final WebClient webClient;

	public FavoritesServiceClient(@Qualifier("favoritesWebClient") WebClient webClient) {
		this.webClient = webClient;
	}

	public StarredServiceDTO update(StarredServiceDTO starredServiceDTO) {
		return webClient.put()
				.uri("/api/starred-service")
				.bodyValue(starredServiceDTO)
				.retrieve()
				.bodyToMono(StarredServiceDTO.class)
				.block();
	}

	public StarredServiceDTO save(HeartRequest heartRequest) {
		return webClient.post()
				.uri("/api/starred-service/save")
				.bodyValue(heartRequest)
				.retrieve()
				.bodyToMono(StarredServiceDTO.class)
				.block();
	}

	public void delete(Long serviceId, Long userId) {
		webClient.delete()
				.uri(uriBuilder -> uriBuilder
						.path("/api/starred-service/delete")
						.queryParam("serviceId", serviceId)
						.queryParam("userId", userId)
						.build())
				.retrieve()
				.bodyToMono(Void.class)
				.block();
	}

	public List<MarketplaceServiceDTO> findAllByUser(Long userId) {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/api/starred-service/user")
						.queryParam("userId", userId)
						.build())
				.retrieve()
				.bodyToFlux(MarketplaceServiceDTO.class)
				.collectList()
				.block();
	}
}