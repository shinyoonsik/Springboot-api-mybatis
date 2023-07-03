package com.springboot.mybatis.service;


import com.springboot.mybatis.model.dto.UserDto;
import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    UserDto getUser(Long id);

    List<UserDto> getUsers(int pageNum, int pageSize);

    UserDto updateUser(UserDto userDto);
    void deleteUser(Long id);
}
