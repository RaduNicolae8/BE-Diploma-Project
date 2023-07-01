package com.diploma.project.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequest {
    private Long id;
    private Long price;
    private String title;
    private String description;
    private String shortDescription;
    private String coverImage;
    private String tags;
    private Long categoryId;
    private Long userId;
}
