package com.example.bookworldrpg.api.media_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MediaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @JoinColumn(name = "GENRE")
    @OneToOne
    private GenreEntity genre;

}
