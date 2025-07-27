package com.books.system.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionStatus {
    USER_ALREADY_EXISTS_CODE("UAE1000", "User already exists. More info"),
    BOOK_ALREADY_EXISTS_CODE("BAE2000", "The book already exists. More info"),
    USER_NOT_FOUND_EXCEPTION("UNF1001", "User not found. More info"),
    BOOK_NOT_FOUND_EXCEPTION("BNF2001", "Book not found. More info");

    private final String code;
    private final String codeMessage;
}
