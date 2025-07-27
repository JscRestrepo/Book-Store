package com.books.system.service;

import com.books.system.event.HandleEvent;

import com.books.system.exception.UserAlreadyExistsException;
import com.books.system.exception.UserNotFoundException;
import com.books.system.interfaces.UserService;
import com.books.system.logs.LoggerInfoApp;
import com.books.system.model.dto.UpdateUserDto;
import com.books.system.model.dto.UserDto;
import com.books.system.model.entity.User;
import com.books.system.model.mapper.UserMapper;
import com.books.system.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final HandleEvent handleEvent;
    private final LoggerInfoApp loggerInfoApp;

    @Override
    public UserDto createUser(UserDto userDto) {
        boolean userExists = userRepository.existsByUsername(userDto.username());

        if (userExists) {
            throw new UserAlreadyExistsException("Username " + userDto.username() + " already exists. Please change the username");
        }

        User user = userMapper.dtoToEntity(userDto);
        userRepository.save(user);
        handleEvent.createEvent(user);

        loggerInfoApp.UserCreatedLog(userDto.email());
        return userMapper.entityToDto(user);
    }

    @Override
    @Cacheable(value = "users", key = "'page_' + #pageable.pageNumber + '_size_' + #pageable.pageSize + '_sort_' + #pageable.sort.toString()")
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public UpdateUserDto updateUser(UpdateUserDto updateUserDto, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UserNotFoundException("User " + updateUserDto.email() + " not found. The information must be validated"));

        userMapper.updateDtoToentity(updateUserDto, user);
        userRepository.save(user);
        return userMapper.entityToUpdateDto(user);
    }
}
