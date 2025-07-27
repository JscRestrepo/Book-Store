package com.books.system.exception;

public class BookExistingException extends RuntimeException {
    public BookExistingException(String message) {
        super(message);
    }
}
