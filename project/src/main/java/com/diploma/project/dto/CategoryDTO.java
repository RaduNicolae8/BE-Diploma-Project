package com.diploma.project.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class CategoryDTO {
    private Long id;
    private String name;
    private String description;
}
