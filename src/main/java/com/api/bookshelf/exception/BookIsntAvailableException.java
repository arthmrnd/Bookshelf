package com.api.bookshelf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookIsntAvailableException extends RuntimeException {
    public BookIsntAvailableException(String title) {
        super("The book "+title+" isn't available at moment.");
    }
}
