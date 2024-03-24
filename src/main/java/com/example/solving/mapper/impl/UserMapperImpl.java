package com.example.solving.mapper.impl;

import com.example.solving.dto.UserResponse;
import com.example.solving.entity.User;
import com.example.solving.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public List<UserResponse> toDtoS(List<User> all) {
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user: all)
            userResponses.add(toDto(user));
        return userResponses;
    }

    private UserResponse toDto(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setNickname(user.getNickname());
        userResponse.setAnsweredTaskCount(user.getAnsweredTasks()!=null? user.getAnsweredTasks().size(): 0);
        userResponse.setCreatedTaskCount(user.getCreatedTasks()!=null? user.getCreatedTasks().size(): 0);
        return userResponse;
    }
}
