package com.example.bookworldrpg.common.util.exceptions;

public class BookworldException extends Error {

    public final transient BookworldExceptionCode error;

    BookworldException(BookworldExceptionCode error) {
        super(error.getCode() + " " + error.getMessage());
        this.error = error;
    }
}
