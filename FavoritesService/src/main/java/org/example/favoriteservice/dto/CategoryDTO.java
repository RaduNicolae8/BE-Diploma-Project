package org.example.favoriteservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CategoryDTO {
    private Long id;
    private String name;
    private String description;
}
