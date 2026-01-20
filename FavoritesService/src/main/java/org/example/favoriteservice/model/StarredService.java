package org.example.favoriteservice.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "StarredService")
public class StarredService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "service_id", nullable = false)
    private Long serviceId;


}
