package org.example.favoriteservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class MarketplaceServiceDTO {
    private Long id;
    private Long price;
    private String title;
    private String description;
    private String shortDescription;
    private String coverImage;
    private String tags;
    private CategoryDTO category;
    private MarketplaceUserDTO user;
    private Boolean isRequest;
}
