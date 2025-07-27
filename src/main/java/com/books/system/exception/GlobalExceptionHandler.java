package com.books.system.exception;

import com.books.system.constant.ExceptionStatus;
import com.books.system.logs.LoggerErrorApp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final LoggerErrorApp loggerErrorApp;

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ExceptionMessage> usernameAlreadyExistsException(UserAlreadyExistsException userAlreadyExistsException) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                HttpStatus.CONFLICT.value(),
                ExceptionStatus.USER_ALREADY_EXISTS_CODE.getCode(),
                userAlreadyExistsException.getMessage(),
                LocalDateTime.now()
        );
        loggerErrorApp.userAlreadyExistsExceptionLog(userAlreadyExistsException);
        return new ResponseEntity<>(exceptionMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BookExistingException.class)
    public ResponseEntity<ExceptionMessage> bookCodeAlreadyExistsException(BookExistingException bookExistingException) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                HttpStatus.CONFLICT.value(),
                ExceptionStatus.BOOK_ALREADY_EXISTS_CODE.getCode(),
                bookExistingException.getMessage(),
                LocalDateTime.now()
        );
        loggerErrorApp.bookAlreadyExistsExceptionLog(bookExistingException);
        return new ResponseEntity<>(exceptionMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionMessage> userNotFoundException(UserNotFoundException userNotFoundException) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                HttpStatus.NOT_FOUND.value(),
                ExceptionStatus.USER_NOT_FOUND_EXCEPTION.getCode(),
                userNotFoundException.getMessage(),
                LocalDateTime.now()
        );
        loggerErrorApp.userNotFoundExceptionLog(userNotFoundException);
        return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ExceptionMessage> bookNotFoundException(BookNotFoundException bookNotFoundException) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                HttpStatus.NOT_FOUND.value(),
                ExceptionStatus.BOOK_NOT_FOUND_EXCEPTION.getCode(),
                bookNotFoundException.getMessage(),
                LocalDateTime.now()
        );
        loggerErrorApp.bookNotFoundException(bookNotFoundException);
        return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
    }
}
