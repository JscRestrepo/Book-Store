package com.books.system.service;

import com.books.system.event.HandleEvent;
import com.books.system.event.UserEvent;
import com.books.system.event.UserRegistered;
import com.books.system.exception.UserExistsException;
import com.books.system.interfaces.UserService;
import com.books.system.model.dto.UserDto;
import com.books.system.model.entity.User;
import com.books.system.model.entity.UserEventHistory;
import com.books.system.model.mapper.EventHistoryMapper;
import com.books.system.model.mapper.UserMapper;
import com.books.system.repository.EventRepository;
import com.books.system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final HandleEvent handleEvent;

    @Override
    public UserDto createUser(UserDto userDto) {
        boolean userExists = userRepository.existsByUsername(userDto.username());

        if (userExists) {
            throw new UserExistsException("Username " + userDto.username() + " already exists. Please change the username");
        }

        User user = userMapper.dtoToEntity(userDto);
        userRepository.save(user);

        handleEvent.createEvent(user);
        return userMapper.entityToDto(user);
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
