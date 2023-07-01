package com.springboot.mybatis.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @Nullable
    private Long id;

    @Nullable
    private String phoneNumber;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String password;

}
