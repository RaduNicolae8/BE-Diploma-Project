package com.diploma.project.dto;

import com.diploma.project.model.MarketplaceService;
import com.diploma.project.model.MarketplaceUser;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class StarredServiceDTO {
    private Long id;
    private MarketplaceUserDTO marketplaceUser;
    private MarketplaceServiceDTO MarketplaceService;
}
