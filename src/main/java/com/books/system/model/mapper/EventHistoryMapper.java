package com.books.system.model.mapper;

import com.books.system.event.UserRegistered;
import com.books.system.model.entity.UserEventHistory;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class EventHistoryMapper {

    public UserEventHistory dtoToEntity(UserRegistered userRegistered) {
        return UserEventHistory.builder()
                .userEventId(userRegistered.userEventId())
                .username(userRegistered.username())
                .registeredAt(userRegistered.registeredAt())
                .registerCount(userRegistered.registerCount())
                .build();
    }

    public UserRegistered entityToDto(UserEventHistory userEventHistory) {
        return new UserRegistered(
                userEventHistory.getUserEventId(),
                userEventHistory.getUsername(),
                userEventHistory.getRegisteredAt(),
                userEventHistory.getRegisterCount()
        );
    }
}
