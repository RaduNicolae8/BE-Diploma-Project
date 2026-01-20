package org.example.favoriteservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class StarredServiceDTO {
    private Long id;
    private Long userId;
    private Long serviceId;
}
