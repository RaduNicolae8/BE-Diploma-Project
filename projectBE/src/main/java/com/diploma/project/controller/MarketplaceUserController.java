package com.diploma.project.controller;

import com.diploma.project.dto.MarketplaceUserDTO;
import com.diploma.project.model.MarketplaceUser;
import com.diploma.project.security.HeartRequest;
import com.diploma.project.service.MarketplaceUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping("/heartService")
//    public ResponseEntity<Void> heartService(@RequestBody HeartRequest heartRequest){
//        ((MarketplaceUserService) getGenericService()).addHeart(heartRequest.getUserId(), heartRequest.getServiceId());
//        return ResponseEntity.ok().build();
//    }

}
