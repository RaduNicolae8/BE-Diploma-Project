package org.example.favoriteservice.feingclients;

import org.example.favoriteservice.dto.MarketplaceUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "${user.service.url}")
public interface MarketplaceUserClient {

	@GetMapping("api/marketplace-user/{id}")
	MarketplaceUserDTO findById(@PathVariable("id") Long id);
}
