package com.example.bookworldrpg.api.media_management.book_management.user_book_library;

import com.example.bookworldrpg.api.media_management.entity.BookEntity;

import java.util.List;

public interface UserBookLibraryService {
    List<BookEntity> findBooksFromUserLibrary(Long userId);
}
