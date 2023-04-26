package com.diploma.project.dto;

import com.diploma.project.model.Category;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class MarketplaceServiceDTO {
    private Long id;
    private Long price;
    private String name;
    private String description;
    private Boolean isGeneratedBySeller;
    private Timestamp dateOfCreation;
    private Category category;
}
