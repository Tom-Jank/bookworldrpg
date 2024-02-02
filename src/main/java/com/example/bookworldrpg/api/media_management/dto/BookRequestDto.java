package com.example.bookworldrpg.api.media_management.dto;

import lombok.Value;

@Value
public class BookRequestDto {

    private final String author;

    private final String title;

    private final String genre;

}
