package com.example.bookworldrpg.api.media;

import jakarta.persistence.*;

@MappedSuperclass
public class MediaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private GenreEnum genre;

}
