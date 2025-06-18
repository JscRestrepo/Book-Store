package com.books.system.event;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public record UserRegistered (@JsonIgnore
                              Long userEventId,
                              String username,
                              LocalDateTime registeredAt,
                              Long registerCount) implements UserEvent {
}
