package com.alamgir.user_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alamgir.user_service.entity.User;
import com.alamgir.user_service.repository.UserRepository;
import com.alamgir.user_service.request.UserRegisterRequest;
import com.alamgir.user_service.response.UserResponse;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String createUserAccount(UserRegisterRequest userRequest) {

        if (userRepository.existsByEmail(userRequest.getEmail())) {
            return "Email already Exist..Try again later";
        }

        User u = new User();
        u.setName(userRequest.getName());
        u.setEmail(userRequest.getEmail());
        u.setPassword(userRequest.getPassword());
        User savedUser = userRepository.save(u);

        if (savedUser != null) {
            return "Register Successfully";
        } else {
            return "Failed to create User ";
        }
    }

    public List<UserResponse> readAllUser() {

        List<User> user = userRepository.findAll();
        List<UserResponse> userResponses=new ArrayList<>();
        for (User u : user) {
            UserResponse response=new UserResponse();
            response.setName(u.getName());
            response.setEmail(u.getEmail());
            userResponses.add(response);

        }
        return userResponses;

    }

}
