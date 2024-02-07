package com.example.bookworldrpg.api.media_management.book_management.user_book_library;


import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user-lib")
public class UserBookLibraryController {
    private final UserBookLibraryService userBookLibraryService;

    @Autowired
    UserBookLibraryController(UserBookLibraryService userBookLibraryService) {
        this.userBookLibraryService = userBookLibraryService;
    }

    @GetMapping
    public List<BookEntity> getUserLibrary(@RequestBody Long id) {
        return userBookLibraryService.findUserBookLibraryCompositeIds(id);
    }
}
