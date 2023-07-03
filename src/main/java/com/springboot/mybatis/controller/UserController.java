package com.springboot.mybatis.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mybatis.model.dto.UserDto;
import com.springboot.mybatis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 10명씩 페이징처리하는 API
     * @param pageNum 페이지 번호
     * @param pageSize 한 페이지에서 보여줄 게시글 수
     *
     * @return ResponseEntity<UserDto>
     */
    @GetMapping
    public PageInfo<UserDto> getUsers(@RequestParam int pageNum, @RequestParam int pageSize){
        List<UserDto> users = userService.getUsers(pageNum, pageSize);
        return PageInfo.of(users);
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        LOGGER.info("[Controller] [method: saveUser] user: {}", userDto);
        userService.saveUser(userDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userDto);
    }
}
