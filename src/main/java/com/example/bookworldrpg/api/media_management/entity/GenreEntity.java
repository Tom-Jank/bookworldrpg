package com.example.bookworldrpg.api.media_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "GENRE")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

}
