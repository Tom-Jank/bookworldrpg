package com.example.bookworldrpg.api.media_management.book_management.user_book_library;

import com.example.bookworldrpg.api.media_management.book_management.book.BookRepository;
import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import com.example.bookworldrpg.api.media_management.entity.UserBookLibrary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserBookLibraryServiceImpl implements UserBookLibraryService {

    private final UserBookLibraryRepository userBookLibraryRepository;
    private final BookRepository bookRepository;

    UserBookLibraryServiceImpl(UserBookLibraryRepository userBookLibraryRepository,
                               BookRepository bookRepository) {
        this.userBookLibraryRepository = userBookLibraryRepository;
        this.bookRepository = bookRepository;
    }
    @Override
    public List<BookEntity> findUserBookLibraryCompositeIds(Long userId) {

        List<Long> bookIds = userBookLibraryRepository.findAllByUserId(userId).stream().map(UserBookLibrary::getBookId).toList();

        return bookRepository.findByIdIn(bookIds);
    }
}
