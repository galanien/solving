package com.example.solving.controller;

import com.example.solving.dto.UserRequest;
import com.example.solving.dto.UserResponse;
import com.example.solving.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public void createUser(@RequestBody UserRequest request){
        userService.createUser(request);
    }

    @GetMapping("/all")
    public List<UserResponse> all(){
        return userService.all();
    }
}
