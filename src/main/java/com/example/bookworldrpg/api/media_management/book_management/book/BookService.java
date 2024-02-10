package com.example.bookworldrpg.api.media_management.book_management.book;

import com.example.bookworldrpg.api.media_management.dto.BookDto;
import com.example.bookworldrpg.api.media_management.dto.BookPageSortRequest;
import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import java.util.List;

public interface BookService {

    BookEntity addNewBook(BookDto bookEntity);

    List<BookEntity> findPaged(BookPageSortRequest pageable);
}
