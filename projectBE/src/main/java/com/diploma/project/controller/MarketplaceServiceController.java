package com.diploma.project.controller;

import com.diploma.project.dto.MarketplaceServiceDTO;
import com.diploma.project.model.MarketplaceService;
import com.diploma.project.security.ServiceRequest;
import com.diploma.project.service.MarketplaceServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/get/sorted")
    public ResponseEntity<List<MarketplaceServiceDTO>> getSorted(@RequestParam Long categoryId, @RequestParam String sort, @RequestParam int min, @RequestParam int max){
        List<MarketplaceServiceDTO> sortedMarketplaceServices = ((MarketplaceServiceService) getGenericService()).getOrderAndSortByCategory(min,max,sort,categoryId);
        return ResponseEntity.ok(sortedMarketplaceServices);
    }

    @GetMapping("/get/user")
    public ResponseEntity<List<MarketplaceServiceDTO>> getByUser(@RequestParam Long userId){
        List<MarketplaceServiceDTO> marketplaceServices = ((MarketplaceServiceService) getGenericService()).getMarketplaceServiceByUserId(userId);
        return ResponseEntity.ok(marketplaceServices);
    }

    @GetMapping("/get/search")
    public ResponseEntity<List<MarketplaceServiceDTO>> getBySearch(@RequestParam String search, @RequestParam String sort, @RequestParam int min, @RequestParam int max){
        List<MarketplaceServiceDTO> marketplaceServices = ((MarketplaceServiceService) getGenericService()).search(search,min,max,sort);
        return ResponseEntity.ok(marketplaceServices);
    }
}
