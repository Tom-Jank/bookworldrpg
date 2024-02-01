package com.example.bookworldrpg.api.media_management.book_management.book_library_management;

import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLibraryRepository extends JpaRepository<BookEntity, Long> {
}
