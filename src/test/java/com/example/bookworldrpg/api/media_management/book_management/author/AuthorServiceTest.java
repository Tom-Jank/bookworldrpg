package com.example.bookworldrpg.api.media_management.book_management.author;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.example.bookworldrpg.api.media_management.entity.AuthorEntity;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @InjectMocks
    AuthorServiceImpl authorService;

    @Mock
    AuthorRepository authorRepository;

    @Test
    public void shouldReturnAuthorWhenAuthorExists() {
        // Given
        AuthorEntity author = AuthorEntity.builder().id(1L).name("Author").build();
        when(authorRepository.findAuthorByName(author.getName())).thenReturn(Optional.of(author));

        // When
        AuthorEntity result = authorService.findAuthorByNameOrCreateNew("Author");

        // Then
        assertNotNull(result);
        assertEquals(author.getId(), result.getId());
        assertEquals(author.getName(), result.getName());
        verify(authorRepository, times(0)).save(any());
    }

    @Test
    public void shouldCreateAndReturnAuthorWhenAuthorExists() {
        // Given
        AuthorEntity author = AuthorEntity.builder().id(1L).name("Author").build();
        when(authorRepository.findAuthorByName(author.getName())).thenReturn(Optional.empty());
        when(authorRepository.save(any())).thenReturn(author);

        // When
        AuthorEntity result = authorService.findAuthorByNameOrCreateNew("Author");

        // Then
        assertNotNull(result);
        assertEquals(author.getId(), result.getId());
        assertEquals(author.getName(), result.getName());
        verify(authorRepository, times(1)).save(any());
    }
}
