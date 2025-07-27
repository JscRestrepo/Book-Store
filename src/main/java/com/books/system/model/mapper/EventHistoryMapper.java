package com.books.system.model.mapper;

import com.books.system.event.UserRegistered;
import com.books.system.event.UserUpdated;
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

    public UserEventHistory updatedDtoToEntity(UserUpdated userUpdated) {
        return UserEventHistory.builder()
                .userEventId(userUpdated.userEventId())
                .username(userUpdated.username())
                .registeredAt(userUpdated.updatedAt())
                .registerCount(userUpdated.updateCount())
                .build();
    }
}
