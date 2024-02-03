package com.example.bookworldrpg.api.media_management.book_management.book;

import com.example.bookworldrpg.api.media_management.book_management.author.AuthorService;
import com.example.bookworldrpg.api.media_management.book_management.author.AuthorServiceImpl;
import com.example.bookworldrpg.api.media_management.book_management.genre.GenreService;
import com.example.bookworldrpg.api.media_management.book_management.genre.GenreServiceImpl;
import com.example.bookworldrpg.api.media_management.dto.BookRequestDto;
import com.example.bookworldrpg.api.media_management.entity.AuthorEntity;
import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import com.example.bookworldrpg.api.media_management.entity.GenreEntity;
import com.example.bookworldrpg.common.util.exceptions.BusinessException;
import com.example.bookworldrpg.common.util.exceptions.BusinessExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final GenreService genreService;

    @Autowired
    BookServiceImpl(
           BookRepository bookRepository,
           GenreServiceImpl genreService,
           AuthorServiceImpl authorService
    ) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @Override
    public List<BookEntity> findAllBooks() {
       return bookRepository.findAll();
    }

    @Override
    public BookEntity addNewBook(BookRequestDto requestedBook) {
        BookEntity bookToCreate = prepareBookTooCreate(requestedBook);
        if ( theBookAlreadyExist(bookToCreate) ) throw new BusinessException(BusinessExceptionCode.B_01);
        return bookRepository.save(bookToCreate);
    }

    private BookEntity prepareBookTooCreate(BookRequestDto requestedBook) {
        GenreEntity genreEntity = genreService.findGenreByNameOrCreateNew(requestedBook.getGenre());
        AuthorEntity authorEntity = authorService.findAuthorByNameOrCreateNew(requestedBook.getAuthor());

        return BookEntity.builder()
                .title(requestedBook.getTitle())
                .author(authorEntity)
                .genre(genreEntity)
                .build();
    }

    private Boolean theBookAlreadyExist(BookEntity bookToCheck) {
        return bookRepository.findByTitleAndGenreIdAndAuthorId(
                bookToCheck.getTitle(),
                bookToCheck.getGenre().getId(),
                bookToCheck.getAuthor().getId())
                .isPresent();
    }
}
