package com.example.bookworldrpg.api.media_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "BOOK")
@Getter
@NoArgsConstructor
public class BookEntity extends MediaEntity {

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private AuthorEntity author;

    @Builder
    BookEntity(Long id, String title, GenreEntity genre, AuthorEntity author) {
        super(id, title, genre);
        this.author = author;
    }
}
