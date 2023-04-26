package com.diploma.project.controller;

import com.diploma.project.dto.MarketplaceUserDTO;
import com.diploma.project.model.MarketplaceUser;
import com.diploma.project.service.MarketplaceUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/marketplace-user")
public class MarketplaceUserController extends GenericController<MarketplaceUser, MarketplaceUserDTO>{

    public MarketplaceUserController(MarketplaceUserService marketplaceUserService) {
        super(marketplaceUserService);
    }

    @PutMapping
    public ResponseEntity<MarketplaceUserDTO> update(@RequestBody MarketplaceUserDTO marketplaceUserDTO){
        MarketplaceUserDTO updatedMarketplaceUser = ((MarketplaceUserService) getGenericService()).update(marketplaceUserDTO);
        return ResponseEntity.ok(updatedMarketplaceUser);
    }
}
