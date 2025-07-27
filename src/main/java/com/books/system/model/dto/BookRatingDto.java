package com.books.system.model.dto;

import com.books.system.model.entity.Book;
import com.books.system.model.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record BookRatingDto(@JsonIgnore
                            Long ratingId,

                            @NotEmpty(message = "Book id not found")
                            Long book,

                            @NotEmpty(message = "This book needs a score")
                            Integer score,

                            @NotEmpty(message = "This book needs a creation date rate")
                            LocalDateTime createdAt,

                            @NotEmpty(message = "This book needs a user")
                            Long user) {
}
