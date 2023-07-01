package com.diploma.project.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ImagesDTO {
    private Long id;
    private MarketplaceServiceDTO marketplaceService;
    private String url;
}
