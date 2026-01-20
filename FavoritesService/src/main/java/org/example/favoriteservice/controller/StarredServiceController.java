package org.example.favoriteservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.favoriteservice.dto.MarketplaceServiceDTO;
import org.example.favoriteservice.dto.StarredServiceDTO;
import org.example.favoriteservice.security.HeartRequest;
import org.example.favoriteservice.service.StarredServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/starred-service")
@RequiredArgsConstructor
public class StarredServiceController {

    private final StarredServiceService starredServiceService;

    @PutMapping
    public ResponseEntity<StarredServiceDTO> update(@RequestBody StarredServiceDTO starredServiceDTO){
        StarredServiceDTO updatedStarredService = starredServiceService.update(starredServiceDTO);
        return ResponseEntity.ok(updatedStarredService);
    }

    @PostMapping("/save")
    public ResponseEntity<StarredServiceDTO> save(@RequestBody HeartRequest heartRequest){
        StarredServiceDTO savedStarredService = starredServiceService.saveRequest(heartRequest.getServiceId(), heartRequest.getUserId());
        return ResponseEntity.ok(savedStarredService);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Long serviceId, @RequestParam Long userId){
        starredServiceService.deleteStarredService(serviceId, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<MarketplaceServiceDTO>> findAllById(@RequestParam Long userId){
        List<MarketplaceServiceDTO> starredServiceDTOList = starredServiceService.findAllByUserId(userId);
        return ResponseEntity.ok(starredServiceDTOList);
    }
}
