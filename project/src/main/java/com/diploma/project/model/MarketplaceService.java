package com.diploma.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "SERVICE")
public class MarketplaceService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "PRICE")
    private Long price;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name="IS_GENERATED_BY_SELLER")
    private Boolean isGeneratedBySeller;
    @Column(name = "DATE_OF_CREATION")
    private Timestamp dateOfCreation;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    
}
