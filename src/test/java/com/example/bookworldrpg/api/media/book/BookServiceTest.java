package com.example.bookworldrpg.api.media.book;

import com.example.bookworldrpg.api.media.GenreEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
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
        BookEntity bookEntity = BookEntity.builder()
                .id(1L)
                .title("Title")
                .author("Author")
                .genre(GenreEnum.ACTION)
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