package com.books.system.model.mapper;

import com.books.system.model.dto.UpdateUserDto;
import com.books.system.model.dto.UserDto;
import com.books.system.model.entity.User;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class UserMapper {

    public User dtoToEntity(UserDto userDto) {
        return User.builder()
                .userId(userDto.userId())
                .name(userDto.name())
                .lastname(userDto.lastname())
                .username(userDto.username())
                .email(userDto.email())
                .password(userDto.password())
                .build();
    }

    public UserDto entityToDto(User user) {
        return new UserDto(
                user.getUserId(),
                user.getName(),
                user.getLastname(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public void updateDtoToentity(UpdateUserDto updateUserDto, User user) {
        user.setName(updateUserDto.name());
        user.setEmail(updateUserDto.email());
        user.setUsername(updateUserDto.username());
    }

    public UpdateUserDto entityToUpdateDto(User user) {
        return new UpdateUserDto(
                user.getName(),
                user.getEmail(),
                user.getUsername()
        );
    }
}
