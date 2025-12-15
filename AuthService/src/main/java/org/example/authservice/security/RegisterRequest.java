package org.example.authservice.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String country;
    private String phoneNumber;
    private String description;
    private String img;
    private Boolean isSeller;
    private Long roleId;
    private String languages;

}
