package com.example.bookworldrpg.api.media_management.book_management.book;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.bookworldrpg.api.media_management.entity.AuthorEntity;
import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import com.example.bookworldrpg.api.media_management.entity.GenreEntity;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

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
}
