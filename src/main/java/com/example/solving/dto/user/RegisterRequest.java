package com.example.solving.dto.user;


import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String nickname;
    private String password;
}
