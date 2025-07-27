package com.books.system.event;

public sealed interface UserEvent permits UserRegistered, UserUpdated {}
