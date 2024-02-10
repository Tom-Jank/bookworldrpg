package com.example.bookworldrpg.api.media_management.book_management.genre;

import com.example.bookworldrpg.api.media_management.entity.GenreEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GenreServiceTest {

  @InjectMocks GenreServiceImpl genreService;

  @Mock GenreRepository genreRepository;

  @Test
  public void shouldReturnGenreWhenGenreExists() {
    // Given
    GenreEntity genre = GenreEntity.builder().id(1L).name("Genre").build();
    when(genreRepository.findGenreByName(genre.getName())).thenReturn(Optional.of(genre));

    // When
    GenreEntity result = genreService.findGenreByNameOrCreateNew("Genre");

    // Then
    assertNotNull(result);
    assertEquals(genre.getId(), result.getId());
    assertEquals(genre.getName(), result.getName());
    verify(genreRepository, times(0)).save(any());
  }

  @Test
  public void shouldCreateAndReturnGenreWhenGenreExists() {
    // Given
    GenreEntity genre = GenreEntity.builder().id(1L).name("Genre").build();
    when(genreRepository.findGenreByName(genre.getName())).thenReturn(Optional.empty());
    when(genreRepository.save(any())).thenReturn(genre);

    // When
    GenreEntity result = genreService.findGenreByNameOrCreateNew("Genre");

    // Then
    assertNotNull(result);
    assertEquals(genre.getId(), result.getId());
    assertEquals(genre.getName(), result.getName());
    verify(genreRepository, times(1)).save(any());
  }
}
