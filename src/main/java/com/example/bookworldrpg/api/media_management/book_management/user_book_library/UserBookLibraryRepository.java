package com.example.bookworldrpg.api.media_management.book_management.user_book_library;

import com.example.bookworldrpg.api.media_management.entity.UserBookLibrary;
import com.example.bookworldrpg.api.media_management.entity.UserBookLibraryId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookLibraryRepository extends JpaRepository<UserBookLibrary, UserBookLibraryId> {
    List<UserBookLibrary> findAllByUserId(Long userId);
}
