package com.springboot.mybatis.controller;

import com.google.gson.Gson;
import com.springboot.mybatis.model.dto.UserDto;
import com.springboot.mybatis.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    private final String URL = "/api/v1/users";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("GET 유저 조회 api")
    void getUser() {
        // given
        Long id = 10L;
        UserDto userDto = new UserDto(id, "01091512561", "ysshin", "test@gmail.com", "1234");
        given(userService.getUser(id)).willReturn(userDto);

        // when
        try {
            mockMvc.perform(get(URL + "/" + id))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name").exists())
                    .andExpect(jsonPath("$.email").exists())
                    .andDo(print());

        } catch (Exception e) {
            throw new RuntimeException("getUser API 실패", e);
        }

        // then
        verify(userService).getUser(id);
    }

    @Test
    @DisplayName("POST 유저 저장 api")
    void saveUser() throws Exception {
        // given
        Long id = 11L;
        UserDto userDto = new UserDto(id, "01091512561", "ysshin", "test@gmail.com", "1234");
        doNothing().when(userService).saveUser(userDto);

        Gson gson = new Gson();
        String content = gson.toJson(userDto);

        // when
        ResultActions result = mockMvc.perform(post(URL)
                .content(content)
                .contentType(MediaType.APPLICATION_JSON));

        // then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.email").exists())
                .andDo(print());

    }
}