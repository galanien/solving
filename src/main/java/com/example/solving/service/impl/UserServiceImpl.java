package com.example.solving.service.impl;

import com.example.solving.dto.UserRequest;
import com.example.solving.entity.User;
import com.example.solving.exception.BadCredentialsException;
import com.example.solving.repository.UserRepository;
import com.example.solving.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public void createUser(UserRequest request) {
        Optional<User> user = userRepository.findByEmailAndNicknameOrNicknameOrEmail(request.getEmail(), request.getNickname(),
                request.getNickname(), request.getEmail());
        if (user.isPresent())
            throw new BadCredentialsException("this email or nickname is already exist!");
        User user1 = new User();
        user1.setEmail(request.getEmail());
        user1.setNickname(request.getNickname());
        userRepository.save(user1);
    }
}
