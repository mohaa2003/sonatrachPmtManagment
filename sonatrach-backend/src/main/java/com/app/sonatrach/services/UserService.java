package com.app.sonatrach.services;

import com.app.sonatrach.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);
    UserDto findById(Integer id);
    List<UserDto> findAll();
    void delete(Integer id);
}
