package com.example.solving.service;

import com.example.solving.dto.UserRequest;
import com.example.solving.dto.UserResponse;

import java.util.List;

public interface UserService {
    void createUser(UserRequest request);

    List<UserResponse> all();
}
