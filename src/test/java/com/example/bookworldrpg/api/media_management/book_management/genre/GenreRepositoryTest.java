package com.example.bookworldrpg.api.media_management.book_management.genre;

import com.example.bookworldrpg.api.media_management.entity.GenreEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class GenreRepositoryTest {

  private final GenreRepository genreRepository;
  private final TestEntityManager testEntityManager;

  @Autowired
  GenreRepositoryTest(GenreRepository genreRepository, TestEntityManager testEntityManager) {
    this.genreRepository = genreRepository;
    this.testEntityManager = testEntityManager;
  }

  @Test
  public void shouldFindGenreByName() {
    // Given
    GenreEntity genre = GenreEntity.builder().name("genre").build();
    testEntityManager.persistAndFlush(genre);

    // When
    Optional<GenreEntity> result = genreRepository.findGenreByName("genre");

    // Then
    assertTrue(result.isPresent());
    assertEquals(genre.getName(), result.get().getName());
  }

  @Test
  public void shouldNotFindGenre() {
    // When
    Optional<GenreEntity> result = genreRepository.findGenreByName("genre");

    // Then
    assertTrue(result.isEmpty());
  }
}
