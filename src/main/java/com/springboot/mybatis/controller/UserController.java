package com.springboot.mybatis.controller;

import com.springboot.mybatis.model.dto.UserDto;
import com.springboot.mybatis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        LOGGER.info("[Controller] [method: getUser] userId: {}", id);
        UserDto userDto = userService.getUser(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userDto);
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        LOGGER.info("[Controller] [method: saveUser] user: {}", userDto);
        userService.saveUser(userDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
