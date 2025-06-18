package com.books.system.interfaces;

import com.books.system.model.dto.UserDto;
import com.books.system.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserDto createUser(UserDto userDto);
    Page<User> getAllUsers(Pageable pageable);
}
