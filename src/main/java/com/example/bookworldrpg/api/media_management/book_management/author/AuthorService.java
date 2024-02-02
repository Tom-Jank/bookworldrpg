package com.example.bookworldrpg.api.media_management.book_management.author;

import com.example.bookworldrpg.api.media_management.entity.AuthorEntity;

import java.util.Optional;

public interface AuthorService {
    Optional<AuthorEntity> findAuthorByName(String name);
}
