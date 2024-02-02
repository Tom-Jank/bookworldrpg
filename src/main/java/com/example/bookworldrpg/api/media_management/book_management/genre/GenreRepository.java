package com.example.bookworldrpg.api.media_management.book_management.genre;

import com.example.bookworldrpg.api.media_management.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long> {

    Optional<GenreEntity> findGenreByName(String name);
}
