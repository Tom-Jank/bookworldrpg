package com.example.bookworldrpg.api.media_management.book_management;

import com.example.bookworldrpg.api.media_management.entity.BookEntity;

import java.util.List;

public interface BookService {
    List<BookEntity> findAllBooks();

    BookEntity addNewBook(BookEntity bookEntity);
}
