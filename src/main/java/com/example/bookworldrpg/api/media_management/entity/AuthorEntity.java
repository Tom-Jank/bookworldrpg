package com.example.bookworldrpg.api.media_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "AUTHOR")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "NAME")
  private String name;
}
