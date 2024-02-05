package com.example.bookworldrpg.api.media_management.book_management.book;

import com.example.bookworldrpg.api.media_management.dto.BookPageSortRequest;
import com.example.bookworldrpg.api.media_management.dto.BookRequestDto;
import com.example.bookworldrpg.api.media_management.entity.BookEntity;

import java.awt.print.Pageable;
import java.util.List;

public interface BookService {

    BookEntity addNewBook(BookRequestDto bookEntity);

    List<BookEntity> findPaged(BookPageSortRequest pageable);

}
