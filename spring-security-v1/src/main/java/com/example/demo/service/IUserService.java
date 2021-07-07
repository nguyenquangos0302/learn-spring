package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.payload.request.user.RegistrationRequest;
import com.example.demo.payload.response.ObjectResult;
import com.example.demo.payload.response.user.RegistrationResponse;
import com.example.demo.payload.response.user.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

@Service
public interface IUserService {

    ObjectResult<RegistrationResponse> save(RegistrationRequest registrationRequest);

    ObjectResult<UserResponse> findUserByUserNameOrEmail(String username, String email);

    ObjectResult<UserResponse> findUserById(String id);

}
