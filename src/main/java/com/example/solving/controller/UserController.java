package com.example.solving.controller;

import com.example.solving.dto.UserRequest;
import com.example.solving.dto.UserResponse;
import com.example.solving.dto.user.LoginResponse;
import com.example.solving.dto.user.RegisterRequest;
import com.example.solving.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/confirm")
    public String confirm(@RequestParam String confirmCode){
        return userService.confirm(confirmCode);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody UserRequest userRequest){
        return userService.login(userRequest);
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest userRequest){
        userService.register(userRequest);
    }


    @GetMapping("/all")
    public List<UserResponse> all(){
        return userService.all();
    }
}
