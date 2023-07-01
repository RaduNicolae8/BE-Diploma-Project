package com.diploma.project.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "IMAGES")
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "URL")
    private String url;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "MARKETPLACE_SERVICE_ID")
    private MarketplaceService marketplaceService;
}
