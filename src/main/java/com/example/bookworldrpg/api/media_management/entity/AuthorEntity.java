package com.example.bookworldrpg.api.media_management.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity(name = "AUTHOR")
@Data
@Builder
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;
}
