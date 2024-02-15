package com.example.bookworldrpg.api.media_management.book_management.book;

import com.example.bookworldrpg.api.media_management.entity.AuthorEntity;
import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import com.example.bookworldrpg.api.media_management.entity.GenreEntity;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class BookRepositoryTest {

    private final TestEntityManager testEntityManager;
    private final BookRepository bookRepository;

    @Autowired
    BookRepositoryTest(BookRepository bookRepository, TestEntityManager testEntityManager) {
        this.bookRepository = bookRepository;
        this.testEntityManager = testEntityManager;
    }

    @Test
    public void shouldFindTitleByUniqueConstraint() {
        // Given
        GenreEntity genre = GenreEntity.builder().name("genre").build();
        AuthorEntity author = AuthorEntity.builder().name("author").build();
        BookEntity book =
                BookEntity.builder().title("Book1").author(author).genre(genre).build();
        testEntityManager.persistAndFlush(author);
        testEntityManager.persistAndFlush(genre);
        testEntityManager.persistAndFlush(book);

        // When
        Optional<BookEntity> result =
                bookRepository.findByTitleAndGenreIdAndAuthorId(book.getTitle(), genre.getId(), author.getId());

        // Then
        assertTrue(result.isPresent());
    }

    @Test
    public void shouldReturnEmptyOptionalIfBookNotFoundByUniqueConstraint() {
        // Given / When
        Optional<BookEntity> result = bookRepository.findByTitleAndGenreIdAndAuthorId("Title", 100L, 100L);

        // Then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldFindByIdWhenProvidedListOfBooks() {
        // Given
        GenreEntity genre = GenreEntity.builder().name("genre").build();
        AuthorEntity author = AuthorEntity.builder().name("author").build();
        BookEntity book1 =
                BookEntity.builder().title("Book1").author(author).genre(genre).build();

        testEntityManager.persistAndFlush(author);
        testEntityManager.persistAndFlush(genre);
        testEntityManager.persistAndFlush(book1);

        List<Long> bookIds = List.of(1L);

        // When
        List<BookEntity> result = bookRepository.findByIdIn(bookIds);

        // Then
        assertNotNull(result);
        assertEquals("Book1", result.get(0).getTitle());
    }
}
