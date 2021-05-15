package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.payload.request.user.RegistrationRequest;
import com.example.demo.payload.response.user.RegistrationResponse;
import com.example.demo.payload.response.user.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    RegistrationResponse save(RegistrationRequest registrationRequest);

    UserResponse findUserByUserName(String username);

    UserResponse findUserByEmail(String email);

}
