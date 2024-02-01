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

    @Column(name = "LEVEL")
    private Long level;

    // TODO change to ProfessionEnum later -> User gets it by profiling based on title genres
    @Column(name = "PROFESSION")
    private String profession;
}
