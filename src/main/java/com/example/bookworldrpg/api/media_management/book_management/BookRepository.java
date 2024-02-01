package com.example.bookworldrpg.api.media_management.book_management;

import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
