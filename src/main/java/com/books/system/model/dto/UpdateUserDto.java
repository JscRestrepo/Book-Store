package com.books.system.model.dto;

import jakarta.validation.constraints.NotEmpty;

public record UpdateUserDto(@NotEmpty(message = "name cannot be empty") String name,

                            @NotEmpty(message = "email cannot be empty") String email,

                            @NotEmpty(message = "username cannot be empty") String username) {}
