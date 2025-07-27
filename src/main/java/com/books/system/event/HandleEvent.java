package com.books.system.event;

import com.books.system.logs.LoggerInfoApp;
import com.books.system.model.entity.User;
import com.books.system.model.entity.UserEventHistory;
import com.books.system.model.mapper.EventHistoryMapper;
import com.books.system.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class HandleEvent {

    private final EventRepository eventRepository;
    private final EventHistoryMapper eventHistoryMapper;
    private final LoggerInfoApp loggerInfoApp;

    private void handleEvent(UserEvent event) {
        Thread.startVirtualThread(() -> {
            switch (event) {
                case UserRegistered registered -> {
                    loggerInfoApp.EventUserRegisteredLog(registered);
                }
                case UserUpdated updated -> {
                    loggerInfoApp.EventUserUpdatedLog(updated);
                }
            }
        });
    }

    public void createEvent(User user) {
        UserEvent event = new UserRegistered(1L, user.getUsername(), LocalDateTime.now(), 1L);
        switch (event) {
            case UserRegistered registered -> {
                UserEventHistory userEventHistory = eventHistoryMapper.dtoToEntity(registered);
                eventRepository.save(userEventHistory);
            }

            case UserUpdated updated -> {
                UserEventHistory userEventHistory = eventHistoryMapper.updatedDtoToEntity(updated);
                eventRepository.save(userEventHistory);
            }
        }
        handleEvent(event);
    }
}
