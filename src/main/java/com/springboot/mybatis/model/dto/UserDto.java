package com.springboot.mybatis.model.dto;


import lombok.*;
import org.springframework.lang.Nullable;

@Data
@Builder
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
