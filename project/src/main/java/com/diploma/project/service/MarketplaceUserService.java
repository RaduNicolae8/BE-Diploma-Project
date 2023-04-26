package com.diploma.project.service;

import com.diploma.project.dto.MarketplaceUserDTO;
import com.diploma.project.exception.CustomException;
import com.diploma.project.mapper.MarketplaceUserMapper;
import com.diploma.project.model.MarketplaceUser;
import com.diploma.project.repository.MarketplaceUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MarketplaceUserService extends GenericService<MarketplaceUser, MarketplaceUserDTO>{

    MarketplaceUserService(MarketplaceUserRepository marketplaceUserRepository, MarketplaceUserMapper marketplaceUserMapper){
        super(marketplaceUserRepository, marketplaceUserMapper);
    }

    public MarketplaceUserDTO update(MarketplaceUserDTO marketplaceUserDTO){
        log.debug("Update MarketplaceUser {}", marketplaceUserDTO.toString());
        MarketplaceUser marketplaceUser = getGenericMapper().toEntity(marketplaceUserDTO);
        Optional<MarketplaceUser> byId = getJpaRepository().findById(marketplaceUser.getId());
        if (byId.isEmpty()) {
            throw new CustomException("MarketplaceUser with id " + marketplaceUser.getId() + " does not exist!", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        }
        MarketplaceUser save = getJpaRepository().save(marketplaceUser);
        log.debug("Updated marketplaceUser with id {}", save.getId());
        return getGenericMapper().toDTO(save);
    }

}
