package com.books.system.event;

import com.books.system.model.entity.User;
import com.books.system.model.entity.UserEventHistory;
import com.books.system.model.mapper.EventHistoryMapper;
import com.books.system.repository.EventRepository;
import com.books.system.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class HandleEvent {

    private final EventRepository eventRepository;
    private final EventHistoryMapper eventHistoryMapper;
    private final static Logger LOG = LoggerFactory.getLogger(HandleEvent.class);

    private void handleEvent(UserEvent event) {
        switch (event) {
            case UserRegistered registered -> LOG.info("¡User {} registered in Bookstore at {}, with the code {}!",
                    registered.username(), registered.registeredAt(), registered.registerCount());
        }
    }

    public void createEvent(User user) {
        UserEvent event = new UserRegistered(1L, user.getUsername(), LocalDateTime.now(), 1L);
        switch (event) {
            case UserRegistered registered -> {
                UserEventHistory userEventHistory = eventHistoryMapper.dtoToEntity(registered);
                eventRepository.save(userEventHistory);
            }
        }
        handleEvent(event);
    }
}
