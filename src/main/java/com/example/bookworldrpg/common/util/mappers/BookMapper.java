package com.example.bookworldrpg.common.util.mappers;

import com.example.bookworldrpg.api.media_management.dto.BookDto;
import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public static BookDto toBookResponseDto(BookEntity bookEntity) {
        return BookDto.builder()
                .title(bookEntity.getTitle())
                .author(bookEntity.getAuthor().getName())
                .genre(bookEntity.getGenre().getName())
                .build();
    }
}
