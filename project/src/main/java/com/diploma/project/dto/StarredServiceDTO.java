package com.diploma.project.dto;

import com.diploma.project.model.MarketplaceService;
import com.diploma.project.model.MarketplaceUser;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class StarredServiceDTO {
    private Long id;
    private MarketplaceUser marketplaceUser;
    private List<MarketplaceService> MarketplaceService;
}
