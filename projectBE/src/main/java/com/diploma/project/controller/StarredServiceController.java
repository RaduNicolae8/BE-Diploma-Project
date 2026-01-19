package com.diploma.project.controller;

import com.diploma.project.dto.MarketplaceServiceDTO;
import com.diploma.project.dto.StarredServiceDTO;
import com.diploma.project.favoriteserviceclient.FavoritesServiceClient;
import com.diploma.project.security.HeartRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/starred-service")
public class StarredServiceController {

    private final FavoritesServiceClient favoritesClient;

    public StarredServiceController(FavoritesServiceClient favoritesClient) {
        this.favoritesClient = favoritesClient;
    }

    @PutMapping
    public ResponseEntity<StarredServiceDTO> update(@RequestBody StarredServiceDTO starredServiceDTO){
        StarredServiceDTO updatedStarredService = favoritesClient.update(starredServiceDTO);
        return ResponseEntity.ok(updatedStarredService);
    }

    @PostMapping("/save")
    public ResponseEntity<StarredServiceDTO> savee(@RequestBody HeartRequest heartRequest) {
        StarredServiceDTO savedStarredService = favoritesClient.save(heartRequest);
        return ResponseEntity.ok(savedStarredService);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Long serviceId, @RequestParam Long userId){
        favoritesClient.delete(serviceId, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<MarketplaceServiceDTO>> findAllById(@RequestParam Long userId){
        List<MarketplaceServiceDTO> starredServiceDTOList = favoritesClient.findAllByUser(userId);
        return ResponseEntity.ok(starredServiceDTOList);
    }


}
