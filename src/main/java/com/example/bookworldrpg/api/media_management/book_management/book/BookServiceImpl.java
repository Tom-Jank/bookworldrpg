package com.example.bookworldrpg.api.media_management.book_management.book;

import com.example.bookworldrpg.api.media_management.book_management.author.AuthorRepository;
import com.example.bookworldrpg.api.media_management.book_management.genre.GenreRepository;
import com.example.bookworldrpg.api.media_management.dto.BookRequestDto;
import com.example.bookworldrpg.api.media_management.entity.AuthorEntity;
import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import com.example.bookworldrpg.api.media_management.entity.GenreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Autowired
    BookServiceImpl(BookRepository bookRepository, GenreRepository genreRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public List<BookEntity> findAllBooks() {
       return bookRepository.findAll();
    }

    @Override
    public BookEntity addNewBook(BookRequestDto requestedBook) {
        String genreName = requestedBook.getGenre();
        String authorName = requestedBook.getAuthor();

        Optional<GenreEntity> genreEntity = genreRepository.findGenreByName(genreName);
        Optional<AuthorEntity> authorEntity = authorRepository.findAuthorByName(authorName);

        genreEntity.ifPresentOrElse(
                (genre) -> { System.out.println(genre);},
                () -> { genreRepository.save(GenreEntity.builder().name(genreName).build()); }
        );

        authorEntity.ifPresentOrElse(
                (author) -> { System.out.println(author);},
                () -> { authorRepository.save(AuthorEntity.builder().name(authorName).build()); }
        );
    }
}
