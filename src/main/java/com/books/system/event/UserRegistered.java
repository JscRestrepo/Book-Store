package com.books.system.event;

import java.time.LocalDateTime;

public record UserRegistered (Long userEventId,
                              String username,
                              LocalDateTime registeredAt,
                              Long registerCount) implements UserEvent {
}
