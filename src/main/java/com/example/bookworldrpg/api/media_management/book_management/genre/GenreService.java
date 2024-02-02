package com.example.bookworldrpg.api.media_management.book_management.genre;

import com.example.bookworldrpg.api.media_management.entity.GenreEntity;

import java.util.Optional;

public interface GenreService {

    Optional<GenreEntity> findGenreByName(String name);

}
