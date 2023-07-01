package com.springboot.mybatis.service;

import com.springboot.mybatis.model.dto.UserDto;

public interface UserService {
    void saveUser(UserDto userDto);
    UserDto getUser(Long id);
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long id);
}
