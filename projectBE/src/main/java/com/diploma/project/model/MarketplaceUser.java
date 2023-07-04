package com.diploma.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "MARKETPLACE_USER")
public class MarketplaceUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "EMAIL", unique = true)
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "IMG")
    private String img;
    @Column(name = "IS_SELLER")
    private Boolean isSeller;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "RESET_PASSWORD_TOKEN")
    private String resetPasswordToken;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ROLE_ID")
    private Role role;
    @Column(name= "LANGUAGES")
    private String languages;


}
