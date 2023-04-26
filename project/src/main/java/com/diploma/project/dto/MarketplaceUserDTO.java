package com.diploma.project.dto;

import com.diploma.project.model.Role;
import com.diploma.project.model.MarketplaceService;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class MarketplaceUserDTO {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Role role;
    private List<MarketplaceService> marketplaceServices;
}
