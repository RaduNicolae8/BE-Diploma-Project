package com.diploma.project.service;

import com.diploma.project.dto.StarredServiceDTO;
import com.diploma.project.exception.CustomException;
import com.diploma.project.mapper.StarredServiceMapper;
import com.diploma.project.model.StarredService;
import com.diploma.project.repository.StarredServiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class StarredServiceService extends GenericService<StarredService, StarredServiceDTO> {
    StarredServiceService(StarredServiceRepository starredServiceRepository, StarredServiceMapper starredServiceMapper) {
        super(starredServiceRepository, starredServiceMapper);
    }

    public StarredServiceDTO update(StarredServiceDTO starredServiceDTO){
        log.debug("Update StarredService {}", starredServiceDTO.toString());
        StarredService starredService = getGenericMapper().toEntity(starredServiceDTO);
        Optional<StarredService> byId = getJpaRepository().findById(starredService.getId());
        if (byId.isEmpty()) {
            throw new CustomException("StarredService with id " + starredService.getId() + " does not exist!", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        }
        StarredService save = getJpaRepository().save(starredService);
        log.debug("Updated starredService with id {}", save.getId());
        return getGenericMapper().toDTO(save);
    }
}
