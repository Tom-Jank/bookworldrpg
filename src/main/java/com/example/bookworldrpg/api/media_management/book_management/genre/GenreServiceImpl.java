package com.example.bookworldrpg.api.media_management.book_management.genre;

import com.example.bookworldrpg.api.media_management.entity.GenreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Optional<GenreEntity> findGenreByName(String name) {
        return this.genreRepository.findGenreByName(name);
    }
}
