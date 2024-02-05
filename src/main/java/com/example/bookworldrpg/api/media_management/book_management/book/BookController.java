package com.example.bookworldrpg.api.media_management.book_management.book;

import com.example.bookworldrpg.api.media_management.dto.BookPageSortRequest;
import com.example.bookworldrpg.api.media_management.dto.BookRequestDto;
import com.example.bookworldrpg.api.media_management.dto.BookResponseDto;
import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import com.example.bookworldrpg.common.util.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    List<BookResponseDto> getPagedBooks(@RequestBody BookPageSortRequest request) {
       return bookService
               .findPaged(request)
               .stream()
               .map(BookMapper::toBookResponseDto)
               .collect(Collectors.toList());
   }

    @PostMapping
    @ResponseBody
    ResponseEntity<BookResponseDto> addNewBook(@RequestBody BookRequestDto bookRequest) {
        BookResponseDto responseDto = BookMapper
                .toBookResponseDto(bookService.addNewBook(bookRequest));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
