package com.example.bookworldrpg.api.media_management.book_management.book;

import com.example.bookworldrpg.api.media_management.book_management.author.AuthorRepository;
import com.example.bookworldrpg.api.media_management.book_management.genre.GenreRepository;
import com.example.bookworldrpg.api.media_management.dto.BookRequestDto;
import com.example.bookworldrpg.api.media_management.dto.BookResponseDto;
import com.example.bookworldrpg.api.media_management.entity.AuthorEntity;
import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import com.example.bookworldrpg.api.media_management.entity.GenreEntity;
import com.example.bookworldrpg.common.util.exceptions.BusinessException;
import com.example.bookworldrpg.common.util.exceptions.BusinessExceptionCode;
import com.example.bookworldrpg.common.util.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Autowired
    BookServiceImpl(
           BookRepository bookRepository,
           GenreRepository genreRepository,
           AuthorRepository authorRepository
    ) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public List<BookEntity> findAllBooks() {
       return bookRepository.findAll();
    }

    @Override
    public BookResponseDto addNewBook(BookRequestDto requestedBook) {
        GenreEntity genreEntity = findGenreOrCreateNew(requestedBook);
        AuthorEntity authorEntity = findAuthorOrCreateNew(requestedBook);

        BookEntity bookToCreate = BookEntity.builder()
                .title(requestedBook.getTitle())
                .author(authorEntity)
                .genre(genreEntity)
                .build();

        if ( theBookAlreadyExist(bookToCreate) ) throw new BusinessException(BusinessExceptionCode.B_01);

        BookEntity savedBook = bookRepository.save(bookToCreate);
        return BookMapper.toBookResponseDto(savedBook);
    }

    private Boolean theBookAlreadyExist(BookEntity bookToCheck) {
        return bookRepository.findByTitleAndGenreIdAndAuthorId(
                bookToCheck.getTitle(),
                bookToCheck.getGenre().getId(),
                bookToCheck.getAuthor().getId())
                .isPresent();
    }

    private GenreEntity findGenreOrCreateNew(BookRequestDto bookRequestDto) {
        String genreName = bookRequestDto.getGenre();
        return genreRepository.findGenreByName(genreName)
                .orElseGet(() -> genreRepository.save(GenreEntity.builder().name(genreName).build()));
    }

    private AuthorEntity findAuthorOrCreateNew(BookRequestDto bookRequestDto) {
        String authorName = bookRequestDto.getAuthor();
        return authorRepository.findAuthorByName(authorName)
                .orElseGet(() -> authorRepository.save(AuthorEntity.builder().name(authorName).build()));
    }
}
