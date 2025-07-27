package com.books.system.exception;

import java.time.LocalDateTime;

public record ExceptionMessage(int status,
                               String code,
                               String errorMessage,
                               LocalDateTime timestamp) {}
