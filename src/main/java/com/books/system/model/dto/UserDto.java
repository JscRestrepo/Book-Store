package com.books.system.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record UserDto(@JsonIgnore Long userId,

                      @NotEmpty(message = "Name is null") String name,

                      @NotEmpty(message = "Lastname is null") String lastname,

                      @NotEmpty(message = "User name is null") String username,

                      @NotEmpty(message = "Email is null")
                      @Email(message = "Email has an invalid format")
                      String email,

                      @NotEmpty(message = "Password is null")
                      @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$",
                              message = ("Password have an invalid format"))
                      String password) {}
