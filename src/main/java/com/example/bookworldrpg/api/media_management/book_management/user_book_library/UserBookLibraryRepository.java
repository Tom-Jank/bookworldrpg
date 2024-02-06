package com.example.bookworldrpg.api.media_management.book_management.user_book_library;

import com.example.bookworldrpg.api.media_management.entity.UserBookLibraryEntity;
import com.example.bookworldrpg.api.media_management.entity.UserBookLibraryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBookLibraryRepository extends JpaRepository<UserBookLibraryEntity, UserBookLibraryId> {
    List<UserBookLibraryEntity> findAllByUserId(Long userId);
}
