package com.books.system.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<ExceptionMessage> usernameAlreadyExistsException(UserExistsException userExistsException) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                HttpStatus.CONFLICT.value(),
                userExistsException.getMessage(),
                LocalDateTime.now()
        );
        LOG.error("Error: Username already exists {}", userExistsException.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BookExistingException.class)
    public ResponseEntity<ExceptionMessage> bookCodeAlreadyExistsException(BookExistingException bookExistingException) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                HttpStatus.CONTINUE.value(),
                bookExistingException.getMessage(),
                LocalDateTime.now()
        );
        LOG.error("Error: The book already exists {}", bookExistingException.getMessage());
        return new ResponseEntity<>(exceptionMessage, HttpStatus.CONFLICT);
    }
}
