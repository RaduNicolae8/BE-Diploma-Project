package com.diploma.project.controller;

import com.diploma.project.dto.MarketplaceServiceDTO;
import com.diploma.project.model.MarketplaceService;
import com.diploma.project.security.ServiceRequest;
import com.diploma.project.service.MarketplaceServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/service")
public class MarketplaceServiceController extends GenericController<MarketplaceService, MarketplaceServiceDTO> {
    public MarketplaceServiceController(MarketplaceServiceService marketplaceServiceService) {
        super(marketplaceServiceService);
    }

    @PostMapping("/save")
    public ResponseEntity<MarketplaceServiceDTO> saveRequest(@RequestBody ServiceRequest serviceRequest){
        MarketplaceServiceDTO marketplaceServiceDTO = ((MarketplaceServiceService) getGenericService()).saveRequest(serviceRequest);
        return ResponseEntity.ok(marketplaceServiceDTO);
    }
    @PutMapping
    public ResponseEntity<MarketplaceServiceDTO> update(@RequestBody MarketplaceServiceDTO marketplaceServiceDTO){
        MarketplaceServiceDTO updatedMarketplaceService = ((MarketplaceServiceService) getGenericService()).update(marketplaceServiceDTO);
        return ResponseEntity.ok(updatedMarketplaceService);
    }

}
