package com.diploma.project.controller;

import com.diploma.project.dto.MarketplaceServiceDTO;
import com.diploma.project.dto.StarredServiceDTO;
import com.diploma.project.model.StarredService;
import com.diploma.project.security.HeartRequest;
import com.diploma.project.service.StarredServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/starred-service")
public class StarredServiceController extends GenericController<StarredService, StarredServiceDTO>{
    public StarredServiceController(StarredServiceService starredServiceService) {
        super(starredServiceService);
    }

    @PutMapping
    public ResponseEntity<StarredServiceDTO> update(@RequestBody StarredServiceDTO starredServiceDTO){
        StarredServiceDTO updatedStarredService = ((StarredServiceService) getGenericService()).update(starredServiceDTO);
        return ResponseEntity.ok(updatedStarredService);
    }

    @PostMapping("/save")
    public ResponseEntity<StarredServiceDTO> savee(@RequestBody HeartRequest heartRequest){
        StarredServiceDTO savedStarredService = ((StarredServiceService) getGenericService()).saveRequest(heartRequest.getServiceId(), heartRequest.getUserId());
        return ResponseEntity.ok(savedStarredService);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Long serviceId, @RequestParam Long userId){
        ((StarredServiceService) getGenericService()).deleteStarredService(serviceId, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<MarketplaceServiceDTO>> findAllById(@RequestParam Long userId){
        List<MarketplaceServiceDTO> starredServiceDTOList = ((StarredServiceService) getGenericService()).findAllByUserId(userId);
        return ResponseEntity.ok(starredServiceDTOList);
    }


}
