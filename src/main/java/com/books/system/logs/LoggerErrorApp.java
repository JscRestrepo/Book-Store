package com.books.system.logs;

import com.books.system.constant.ExceptionStatus;
import com.books.system.exception.BookExistingException;
import com.books.system.exception.BookNotFoundException;
import com.books.system.exception.UserAlreadyExistsException;
import com.books.system.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoggerErrorApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerErrorApp.class);

    public void userAlreadyExistsExceptionLog(UserAlreadyExistsException userAlreadyExistsException) {
        logError(ExceptionStatus.USER_ALREADY_EXISTS_CODE, userAlreadyExistsException.getMessage());
    }

    public void bookAlreadyExistsExceptionLog(BookExistingException bookExistingException){
        logError(ExceptionStatus.BOOK_ALREADY_EXISTS_CODE, bookExistingException.getMessage());
    }

    public void userNotFoundExceptionLog(UserNotFoundException userNotFoundException) {
        logError(ExceptionStatus.USER_NOT_FOUND_EXCEPTION, userNotFoundException.getMessage());
    }

    public void bookNotFoundException(BookNotFoundException bookNotFoundException) {
        logError(ExceptionStatus.BOOK_NOT_FOUND_EXCEPTION, bookNotFoundException.getMessage());
    }

    private void logError(ExceptionStatus exceptionStatus, String message) {
        LOGGER.error("Error {}: {}='{}'", exceptionStatus.getCode(), exceptionStatus.getCodeMessage(), message);
    }
}
