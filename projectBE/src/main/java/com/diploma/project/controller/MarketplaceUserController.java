package com.diploma.project.controller;

import com.diploma.project.dto.MarketplaceUserDTO;
import com.diploma.project.model.MarketplaceUser;
import com.diploma.project.service.MarketplaceUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/marketplace-user")
public class MarketplaceUserController extends GenericController<MarketplaceUser, MarketplaceUserDTO>{

    public MarketplaceUserController(MarketplaceUserService marketplaceUserService) {
        super(marketplaceUserService);
    }

//    @GetMapping("/getUser")
//    public String getUser(Authentication authentication){
//        return authentication.getName();
//    }
    @PutMapping
    public ResponseEntity<MarketplaceUserDTO> update(@RequestBody MarketplaceUserDTO marketplaceUserDTO){
        MarketplaceUserDTO updatedMarketplaceUser = ((MarketplaceUserService) getGenericService()).update(marketplaceUserDTO);
        return ResponseEntity.ok(updatedMarketplaceUser);
    }
}
