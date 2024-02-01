package com.example.bookworldrpg.api.media.book;

import com.example.bookworldrpg.api.media_management.entity.GenreEnum;
import com.example.bookworldrpg.api.media_management.book_management.BookRepository;
import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class BookRepositoryTest {

    private final BookRepository bookRepository;

    @Autowired
    BookRepositoryTest(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Test
    public void shouldFetchAllBooks() {
        // Given
        BookEntity bookEntity1 = BookEntity.builder()
                .id(1L)
                .title("Book1")
                .author("Author")
                .genre(GenreEnum.ACTION)
                .build();
        BookEntity bookEntity2 = BookEntity.builder()
                .id(2L)
                .title("Book2")
                .author("Author")
                .genre(GenreEnum.ROMANCE)
                .build();

        bookRepository.save(bookEntity1);
        bookRepository.save(bookEntity2);
        // When
        List<BookEntity> result = bookRepository.findAll();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Book1", result.get(0).getTitle());
        assertEquals("Book2", result.get(1).getTitle());
    }
}
