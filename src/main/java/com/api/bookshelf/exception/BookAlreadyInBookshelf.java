package com.api.bookshelf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class BookAlreadyInBookshelf extends RuntimeException {
    public BookAlreadyInBookshelf(String title) {
        super("Book "+title+" already in the bookshelf");
    }
}
