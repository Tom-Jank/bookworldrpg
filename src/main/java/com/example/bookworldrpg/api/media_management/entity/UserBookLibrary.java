package com.example.bookworldrpg.api.media_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Getter;

@Entity
@IdClass(UserBookLibraryId.class)
@Getter
public class UserBookLibrary {
  @Id Long userId;
  @Id Long bookId;
}
