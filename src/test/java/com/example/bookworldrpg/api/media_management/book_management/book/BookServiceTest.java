package com.example.bookworldrpg.api.media_management.book_management.book;

import com.example.bookworldrpg.api.media_management.book_management.author.AuthorServiceImpl;
import com.example.bookworldrpg.api.media_management.book_management.genre.GenreServiceImpl;
import com.example.bookworldrpg.api.media_management.dto.BookRequestDto;
import com.example.bookworldrpg.api.media_management.entity.AuthorEntity;
import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import com.example.bookworldrpg.api.media_management.entity.GenreEntity;
import com.example.bookworldrpg.common.util.exceptions.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class BookServiceTest {

    @InjectMocks
    BookServiceImpl bookService;

    @Mock
    BookRepository bookRepository;

    @Mock
    AuthorServiceImpl authorService;

    @Mock
    GenreServiceImpl genreService;

    @Test
    public void shouldAddNewBookWhenValidationPasses() {
        GenreEntity genre = GenreEntity.builder().id(1L).name("genre").build();
        AuthorEntity author = AuthorEntity.builder().id(1L).name("author").build();
        BookEntity bookEntity = BookEntity.builder().id(1L).title("book").author(author).genre(genre).build();
        BookRequestDto requestDto = BookRequestDto.builder().title("book").author("author").genre("genre").build();

        when(genreService.findGenreByNameOrCreateNew(any())).thenReturn(genre);
        when(authorService.findAuthorByNameOrCreateNew(any())).thenReturn(author);
        when(bookRepository.findByTitleAndGenreIdAndAuthorId(any(), any(), any())).thenReturn(Optional.empty());
        when(bookRepository.save(any())).thenReturn(bookEntity);

        // When
        BookEntity result = bookService.addNewBook(requestDto);

        // Then
        Assertions.assertNotNull(result);
        Assertions.assertEquals("book", result.getTitle());
        Assertions.assertEquals("genre", result.getGenre().getName());
        Assertions.assertEquals("author", result.getAuthor().getName());
    }

    @Test
    public void shouldThrowBusinessExceptionWhenBookAlreadyExists() {
        GenreEntity genre = GenreEntity.builder().id(1L).name("genre").build();
        AuthorEntity author = AuthorEntity.builder().id(1L).name("author").build();
        BookEntity bookEntity = BookEntity.builder().id(1L).title("book").author(author).genre(genre).build();
        BookRequestDto requestDto = BookRequestDto.builder().title("book").author("author").genre("genre").build();

        when(genreService.findGenreByNameOrCreateNew(any())).thenReturn(genre);
        when(authorService.findAuthorByNameOrCreateNew(any())).thenReturn(author);
        when(bookRepository.findByTitleAndGenreIdAndAuthorId(any(), any(), any())).thenReturn(Optional.of(bookEntity));

        // When / Then
        BusinessException exception = assertThrows(BusinessException.class, () -> bookService.addNewBook(requestDto));
        assertEquals("B-01 Could not add new book. This book already exists!", exception.getMessage());
    }
}
