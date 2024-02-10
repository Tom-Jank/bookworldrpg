package com.example.bookworldrpg.api.media_management.book_management.author;

import com.example.bookworldrpg.api.media_management.entity.AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    AuthorServiceImpl(
            AuthorRepository authorRepository
    ) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity findAuthorByNameOrCreateNew(String name) {
        return authorRepository.findAuthorByName(name)
                .orElseGet(() -> authorRepository.save(AuthorEntity.builder().name(name).build()));
    }
}
