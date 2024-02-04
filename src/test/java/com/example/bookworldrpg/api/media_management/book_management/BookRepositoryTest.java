package com.example.bookworldrpg.api.media_management.book_management;

import com.example.bookworldrpg.api.media_management.book_management.author.AuthorRepository;
import com.example.bookworldrpg.api.media_management.book_management.book.BookRepository;
import com.example.bookworldrpg.api.media_management.book_management.genre.GenreRepository;
import com.example.bookworldrpg.api.media_management.entity.AuthorEntity;
import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import com.example.bookworldrpg.api.media_management.entity.GenreEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class BookRepositoryTest {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Autowired
    BookRepositoryTest(
            BookRepository bookRepository,
            AuthorRepository authorRepository,
            GenreRepository genreRepository
    ) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @Test
    public void shouldFindTitleByUniqueConstraint() {
        // Given
        GenreEntity genre = GenreEntity.builder().id(1L).name("genre").build();
        AuthorEntity author = AuthorEntity.builder().id(1L).name("author").build();
        BookEntity bookEntity = BookEntity.builder()
                .id(1L)
                .title("Book1")
                .author(author)
                .genre(genre)
                .build();
        genreRepository.save(genre);
        authorRepository.save(author);
        bookRepository.save(bookEntity);

        // When
        Optional<BookEntity> result = bookRepository.findByTitleAndGenreIdAndAuthorId(bookEntity.getTitle(), genre.getId(), author.getId());

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
