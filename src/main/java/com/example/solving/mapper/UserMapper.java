package com.example.solving.mapper;

import com.example.solving.dto.UserResponse;
import com.example.solving.entity.User;

import java.util.List;

public interface UserMapper {
    List<UserResponse> toDtoS(List<User> all);
}
