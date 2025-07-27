package com.books.system.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record BookDto(@JsonIgnore
                      Long bookId,

                      @NotEmpty(message = "Title is empty")
                      String title,

                      @NotEmpty(message = "Bok code is empty")
                      @Pattern(regexp = "^[a-zA-Z0-9]{5,10}$",
                              message = "Book code have an invalid format")
                      String bookCode,

                      @NotEmpty(message = "Author is empty")
                      String author,

                      @NotEmpty(message = "Price is empty")
                      Double price) {
}
