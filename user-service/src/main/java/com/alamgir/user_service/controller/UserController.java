package com.alamgir.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alamgir.user_service.repository.UserRepository;
import com.alamgir.user_service.request.UserRegisterRequest;
import com.alamgir.user_service.response.UserRegisterResponse;
import com.alamgir.user_service.response.UserResponse;
import com.alamgir.user_service.service.UserService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome ";
    }

    @PostMapping("/create")
    public ResponseEntity<UserRegisterResponse> postMethodName(@Valid @RequestBody UserRegisterRequest request) {
        String msg = userService.createUserAccount(request);
        return ResponseEntity.ok(new UserRegisterResponse(request.getName(), request.getEmail(), msg));
    }

    @GetMapping("/read")
    public List<UserResponse> loadAllUser() {
        return userService.readAllUser();
    }

}
