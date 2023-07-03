package com.springboot.mybatis.mapper;

import com.springboot.mybatis.model.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    void insertUser(UserDto userDto);
    UserDto selectUser(Long id);
    List<UserDto> selectUsers();
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long id);

}
