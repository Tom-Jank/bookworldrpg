package com.example.bookworldrpg.api.media_management.book_management.book;

import com.example.bookworldrpg.api.media_management.dto.BookRequestDto;
import com.example.bookworldrpg.api.media_management.dto.BookResponseDto;
import com.example.bookworldrpg.api.media_management.entity.BookEntity;

import java.util.List;

public interface BookService {
    List<BookEntity> findAllBooks();

    BookResponseDto addNewBook(BookRequestDto bookEntity);
}
