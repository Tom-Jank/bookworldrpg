package com.example.bookworldrpg.api.media.book;

import com.example.bookworldrpg.api.media.MediaEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "BOOK")
@Data
public class BookEntity extends MediaEntity {

    @Column(name = "AUTHOR")
    private String author;

}
