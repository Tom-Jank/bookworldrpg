package com.example.bookworldrpg.api.media_management.dto;

import lombok.Value;

@Value
public class BookResponseDto {
    private final String title;
    private final AuthorDto author;
    private final GenreDto genre;
}
