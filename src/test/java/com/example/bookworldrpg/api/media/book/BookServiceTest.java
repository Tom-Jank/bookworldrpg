package com.example.bookworldrpg.api.media.book;

import com.example.bookworldrpg.api.media_management.book_management.BookRepository;
import com.example.bookworldrpg.api.media_management.book_management.BookServiceImpl;
import com.example.bookworldrpg.api.media_management.entity.AuthorEntity;
import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import com.example.bookworldrpg.api.media_management.entity.GenreEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class BookServiceTest {

    @InjectMocks
    BookServiceImpl bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void shouldFindAllBooks() {
        // Given
        GenreEntity genre = GenreEntity.builder().id(1L).name("genre").build();
        AuthorEntity author = AuthorEntity.builder().id(1L).name("author").build();
        BookEntity bookEntity = BookEntity.builder()
                .id(1L)
                .title("Title")
                .author(author)
                .genre(genre)
                .build();
        List<BookEntity> entities = new ArrayList<>();
        entities.add(bookEntity);

        when(bookRepository.findAll()).thenReturn(entities);

        // When
        List<BookEntity> result = bookRepository.findAll();

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
    }
}
