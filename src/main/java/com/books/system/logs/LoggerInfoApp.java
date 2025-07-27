package com.books.system.logs;

import com.books.system.event.UserRegistered;
import com.books.system.event.UserUpdated;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LoggerInfoApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerInfoApp.class);

    public void UserCreatedLog(String email) {
        LOGGER.info("User created with email='{}'", email);
    }

    public void BookCreatedLog(String title) {
        LOGGER.info("Book created: title='{}'", title);
    }

    public void PrintLogBooks(List<String> title) {
        LOGGER.info("All available books: title='{}'", title);
    }

    public void EventUserRegisteredLog(UserRegistered registered) {
        LOGGER.info("¡User {} registered in Bookstore at {}, with code {}!",
                registered.username(), registered.registeredAt(), registered.registerCount());
    }

    public void EventUserUpdatedLog(UserUpdated userUpdated) {
        LOGGER.info("!User {} updated in Bookstore at {}, with code {}!",
                userUpdated.username(), userUpdated.updatedAt(), userUpdated.updateCount());
    }
}
