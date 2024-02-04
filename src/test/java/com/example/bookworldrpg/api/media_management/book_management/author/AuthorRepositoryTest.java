package com.example.bookworldrpg.api.media_management.book_management.author;

import com.example.bookworldrpg.api.media_management.entity.AuthorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class AuthorRepositoryTest {

    private final AuthorRepository authorRepository;
    private final TestEntityManager testEntityManager;

    @Autowired
    AuthorRepositoryTest(
            AuthorRepository authorRepository,
            TestEntityManager testEntityManager
    ) {
        this.authorRepository = authorRepository;
        this.testEntityManager = testEntityManager;
    }

    @Test
    public void shouldFindAuthorByName() {
        // Given
        AuthorEntity author = AuthorEntity.builder().name("Author").build();
        testEntityManager.persistAndFlush(author);

        // When
        Optional<AuthorEntity> result = authorRepository.findAuthorByName("Author");

        // Then
        assertTrue(result.isPresent());
        assertEquals(author.getName(), result.get().getName());
    }

    @Test
    public void shouldNotFindAuthorByName() {
        // Given/When
        Optional<AuthorEntity> result = authorRepository.findAuthorByName("Author");

        // Then
        assertTrue(result.isEmpty());
    }
}
