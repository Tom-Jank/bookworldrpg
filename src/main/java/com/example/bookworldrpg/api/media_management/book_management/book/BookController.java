package com.example.bookworldrpg.api.media_management.book_management.book;

import com.example.bookworldrpg.api.media_management.dto.BookRequestDto;
import com.example.bookworldrpg.api.media_management.dto.BookResponseDto;
import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    List<BookEntity> getAllBooks() {
       return bookService.findAllBooks();
   }

    @PostMapping
    @ResponseBody
    BookResponseDto addNewBook(@RequestBody BookRequestDto bookRequest) {
        BookResponseDto savedBook = bookService.addNewBook(bookRequest);
        return savedBook;
    }
}
