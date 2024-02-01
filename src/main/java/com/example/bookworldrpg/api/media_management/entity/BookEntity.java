package com.example.bookworldrpg.api.media_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "BOOK")
@Getter
@NoArgsConstructor
public class BookEntity extends MediaEntity {

    @Column(name = "AUTHOR")
    private String author;

    @Builder
    BookEntity(Long id, String title, GenreEnum genre, String author) {
        super(id, title, genre);
        this.author = author;
    }
}
