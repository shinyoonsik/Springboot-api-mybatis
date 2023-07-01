package com.springboot.mybatis.mapper;

import com.springboot.mybatis.model.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insertUser(UserDto userDto);
    UserDto selectUser(Long id);
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long id);

}
