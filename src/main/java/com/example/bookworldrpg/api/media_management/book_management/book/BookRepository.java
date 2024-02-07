package com.example.bookworldrpg.api.media_management.book_management.book;

import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    Optional<BookEntity> findByTitleAndGenreIdAndAuthorId(String title, Long genreId, Long authorId);

    List<BookEntity> findByIdIn(List<Long> bookIds);

}
