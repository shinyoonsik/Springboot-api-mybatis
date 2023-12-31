package com.springboot.mybatis.service.impl;


import com.github.pagehelper.PageHelper;
import com.springboot.mybatis.mapper.UserMapper;
import com.springboot.mybatis.model.dto.UserDto;
import com.springboot.mybatis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    @Transactional
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
    public List<UserDto> getUsers(int pageNum, int pageSize) {
        // PageHelper는 startPage 메서드를 호출한 후에 다음으로 실행되는 MyBatis 쿼리에만 페이징 처리를 적용된다
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectUsers();
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
