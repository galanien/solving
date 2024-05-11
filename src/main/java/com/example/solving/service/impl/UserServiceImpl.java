package com.example.solving.service.impl;

import com.example.solving.config.JwtService;
import com.example.solving.dto.UserRequest;
import com.example.solving.dto.UserResponse;
import com.example.solving.dto.user.LoginResponse;
import com.example.solving.dto.user.RegisterRequest;
import com.example.solving.entity.User;
import com.example.solving.exception.BadCredentialsException;
import com.example.solving.mapper.UserMapper;
import com.example.solving.mapper.impl.EmailSenderService;
import com.example.solving.repository.UserRepository;
import com.example.solving.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final EmailSenderService senderService;
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

    @Override
    public List<UserResponse> all() {
        return userMapper.toDtoS(userRepository.findAll());
    }

    @Override
    public void register(RegisterRequest userRequest) {
        if (userRepository.findByEmailAndNicknameOrNicknameOrEmail(userRequest.getEmail(), userRequest.getNickname(),
                userRequest.getNickname(), userRequest.getEmail()).isPresent())
            throw new BadCredentialsException("this email or nickname is already exist!");
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setNickname(userRequest.getNickname());
        user.setPassword(encoder.encode(userRequest.getPassword()));
        String confirmCode = UUID.randomUUID().toString();
        user.setConfirmCode(confirmCode);
        senderService.sendEmail(user.getEmail(), "Confirm your email", "http://localhost:8080/api/users/confirm/" + confirmCode);
        userRepository.save(user);
    }

    @Override
    public LoginResponse login(UserRequest userRequest) {

        Optional<User> user = userRepository.findByNicknameOrEmail(userRequest.getEmail(), userRequest.getEmail());
        if (user.isPresent())
            throw new BadCredentialsException("this email is not exist!");
        if (!user.get().getConfirmCode().equals("authenticated")){
            throw new BadCredentialsException("please confirm your email");
        }
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getEmail(), userRequest.getPassword()));
        }
        catch (Exception e){
            throw new BadCredentialsException("bad credentials");
        }
        String token = jwtService.generateToken(user.get());
        return new LoginResponse(token);
    }

    @Override
    public String confirm(String confirmCode) {
        Optional<User> user = userRepository.findByConfirmCode(confirmCode);
        if (user.isPresent()){
            user.get().setConfirmCode("authenticated");
            userRepository.save(user.get());
            return "confirmed";
        }
        return "not confirmed";
    }
}
