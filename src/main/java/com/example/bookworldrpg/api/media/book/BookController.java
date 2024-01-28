package com.example.bookworldrpg.api.media.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookController {

    private final BookServiceImpl bookService;

    @Autowired
    BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    List<BookEntity> getAllBooks() {
       return bookService.findAllBooks();
   }
}
