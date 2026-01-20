package org.example.favoriteservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class MarketplaceUserDTO  {
    private Long id;
    private String email;
    @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;
    private String country;
    private String phoneNumber;
    private String description;
    private String img;
    private Boolean isSeller;
    private RoleDTO role;
    @JsonIgnore
    private String resetPasswordToken;
    private String languages;
}
