package com.springboot.mybatis.service.impl;

import com.springboot.mybatis.mapper.UserMapper;
import com.springboot.mybatis.model.dto.UserDto;
import com.springboot.mybatis.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("user저장 테스트")
    void saveUser() {
        // given
        UserDto userDto = UserDto.builder()
                .email("myTest@test.com")
                .name("leo")
                .password("1234")
                .phoneNumber("01091912345")
                .build();

        // when
        userService.saveUser(userDto);

        // then
        assertTrue(userDto.getId() > 0);

    }

    @Test
    @DisplayName("user조회 테스트")
    void getUser() {
        // given
        UserDto userDto = UserDto.builder()
                .email("myTest@test.com")
                .name("rio")
                .password("1234")
                .phoneNumber("01091912345")
                .build();

        userService.saveUser(userDto);

        // when
        UserDto result = userService.getUser(userDto.getId());

        // then
        assertEquals("rio", userDto.getName());
    }
}