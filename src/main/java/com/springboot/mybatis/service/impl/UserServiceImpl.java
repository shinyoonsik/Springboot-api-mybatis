package com.springboot.mybatis.service.impl;


import com.springboot.mybatis.mapper.UserMapper;
import com.springboot.mybatis.model.dto.UserDto;
import com.springboot.mybatis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void saveUser(UserDto userDto) {
        LOGGER.info("[method: saveUser] 매개변수: {}", userDto);
        Objects.requireNonNull(userDto, "userDto should not be null");

        userMapper.insertUser(userDto);
        LOGGER.info("저장된 user: {}", userDto);
    }

    @Override
    public UserDto getUser(Long id) {
        LOGGER.info("[method: getUSer] 매개변수: {}", id);
        Objects.requireNonNull(id, "id should not be null");

        UserDto userDto = userMapper.selectUser(id);
        LOGGER.info("조회한 user: {}", userDto);

        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
