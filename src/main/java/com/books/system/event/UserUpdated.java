package com.books.system.event;

import java.time.LocalDateTime;

public record UserUpdated (Long userEventId,
                           String username,
                           LocalDateTime updatedAt,
                           Long updateCount) implements UserEvent {
}
