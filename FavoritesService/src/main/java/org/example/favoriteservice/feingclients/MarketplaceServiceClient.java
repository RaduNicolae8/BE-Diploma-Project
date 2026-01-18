package org.example.favoriteservice.feingclients;

import org.example.favoriteservice.dto.MarketplaceServiceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "marketplace-service", url = "${marketplace.service.url}")
public interface MarketplaceServiceClient {

	@GetMapping("/api/service/{id}")
	MarketplaceServiceDTO findById(@PathVariable("id") Long id);
}