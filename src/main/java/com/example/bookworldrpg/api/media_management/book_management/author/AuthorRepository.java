package com.example.bookworldrpg.api.media_management.book_management.author;

import com.example.bookworldrpg.api.media_management.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    Optional<AuthorEntity> findAuthorByName(String name);

}
