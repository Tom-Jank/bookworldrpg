package com.example.bookworldrpg.api.media_management.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BookResponseDto {
    private final String title;
    private final String author;
    private final String genre;
}
