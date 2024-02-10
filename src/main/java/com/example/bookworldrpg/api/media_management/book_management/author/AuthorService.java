package com.example.bookworldrpg.api.media_management.book_management.author;

import com.example.bookworldrpg.api.media_management.entity.AuthorEntity;

public interface AuthorService {
  AuthorEntity findAuthorByNameOrCreateNew(String name);
}
