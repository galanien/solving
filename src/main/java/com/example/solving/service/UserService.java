package com.example.solving.service;

import com.example.solving.dto.UserRequest;
import com.example.solving.dto.UserResponse;
import com.example.solving.dto.user.LoginResponse;
import com.example.solving.dto.user.RegisterRequest;

import java.util.List;

public interface UserService {
    void createUser(UserRequest request);

    List<UserResponse> all();

    void register(RegisterRequest userRequest);

    LoginResponse login(UserRequest userRequest);

    String confirm(String confirmCode);
}
