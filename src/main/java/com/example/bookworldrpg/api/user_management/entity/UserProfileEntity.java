package com.example.bookworldrpg.api.user_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity(name = "USER_PROFILE")
@Getter
@AllArgsConstructor
public class UserProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "EXPERIENCE")
    private Long experience;

    @Column(name = "USER_LEVEL")
    private Long level;
}
