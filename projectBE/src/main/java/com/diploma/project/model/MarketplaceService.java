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
@Table(name = "MARKETPLACE_SERVICE")
public class MarketplaceService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "PRICE")
    private Long price;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION",length = 10000)
    private String description;
    @Column(name = "SHORT_DESCRIPTION")
    private String shortDescription;
    @Column(name = "COVER_IMAGE")
    private String coverImage;
    @Column(name = "TAGS")
    private String tags;
    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "USER_ID")
    private MarketplaceUser user;
    @Column(name = "IS_REQUEST")
    private Boolean isRequest;
}
