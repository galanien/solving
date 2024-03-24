package com.example.solving.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String email;
    private String nickname;
    private Integer createdTaskCount;
    private Integer answeredTaskCount;
}
