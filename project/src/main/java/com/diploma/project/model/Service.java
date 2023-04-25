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
@Table(name = "SERVICE")
public class Service {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "PRICE")
    private Long price;
    private String name;
    private String description;
    
}
