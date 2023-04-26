package com.diploma.project.controller;

import com.diploma.project.dto.StarredServiceDTO;
import com.diploma.project.model.StarredService;
import com.diploma.project.service.StarredServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
