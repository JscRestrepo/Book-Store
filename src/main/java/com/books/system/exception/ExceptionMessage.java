package com.books.system.exception;

import java.time.LocalDateTime;

public record ExceptionMessage(int statusCode, String errorMessage, LocalDateTime timestamp) {}
