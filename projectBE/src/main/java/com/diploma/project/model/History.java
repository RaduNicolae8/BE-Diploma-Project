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
@Table(name = "HISTORY")
public class History {

    // This entity is meant to keep track of all the services that the user has requested
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @JoinColumn(name = "SERVICE_ID")
    private List<MarketplaceService> marketplaceService;
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private MarketplaceUser marketplaceUser;

}
