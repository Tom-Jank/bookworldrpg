package com.example.bookworldrpg.api.media_management.book_management;

import com.example.bookworldrpg.api.media_management.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookEntity> findAllBooks() {
       return bookRepository.findAll();
    }

    @Override
    public BookEntity addNewBook(BookEntity requestedBook) {
        return bookRepository.save(requestedBook);
    }
}
