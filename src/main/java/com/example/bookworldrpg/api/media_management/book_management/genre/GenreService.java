package com.example.bookworldrpg.api.media_management.book_management.genre;

import com.example.bookworldrpg.api.media_management.entity.GenreEntity;

public interface GenreService {

    GenreEntity findGenreByNameOrCreateNew(String name);

}
