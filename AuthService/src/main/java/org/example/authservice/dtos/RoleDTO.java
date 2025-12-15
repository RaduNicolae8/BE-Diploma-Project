package org.example.authservice.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RoleDTO {
    private Long id;
    private String roleName;
}
