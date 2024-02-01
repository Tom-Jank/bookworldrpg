package com.example.bookworldrpg.api.media_management.book_management;

import com.example.bookworldrpg.api.media_management.dto.BookRequestDto;
import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookController {

    private final BookService bookService;

    private final ModelMapper modelMapper;

    @Autowired
    BookController(BookServiceImpl bookService, ModelMapper modelMapper) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    List<BookEntity> getAllBooks() {
       return bookService.findAllBooks();
   }

    @PostMapping
    @ResponseBody
    BookEntity addNewBook(@RequestBody BookRequestDto bookRequest) {
        return new BookEntity();
    }
}
