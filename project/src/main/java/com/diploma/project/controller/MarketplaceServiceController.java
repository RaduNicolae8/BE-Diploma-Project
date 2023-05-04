package com.diploma.project.controller;

import com.diploma.project.dto.MarketplaceServiceDTO;
import com.diploma.project.model.MarketplaceService;
import com.diploma.project.service.MarketplaceServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/marketplace-service")
public class MarketplaceServiceController extends GenericController<MarketplaceService, MarketplaceServiceDTO> {
    public MarketplaceServiceController(MarketplaceServiceService marketplaceServiceService) {
        super(marketplaceServiceService);
    }

    @PutMapping
    public ResponseEntity<MarketplaceServiceDTO> update(@RequestBody MarketplaceServiceDTO marketplaceServiceDTO){
        MarketplaceServiceDTO updatedMarketplaceService = ((MarketplaceServiceService) getGenericService()).update(marketplaceServiceDTO);
        return ResponseEntity.ok(updatedMarketplaceService);
    }

}
