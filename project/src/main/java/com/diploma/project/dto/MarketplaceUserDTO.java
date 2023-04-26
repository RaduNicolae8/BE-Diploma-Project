package com.diploma.project.dto;

import com.diploma.project.model.Role;
import com.diploma.project.model.Service;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
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
    private List<Service> services;
}
