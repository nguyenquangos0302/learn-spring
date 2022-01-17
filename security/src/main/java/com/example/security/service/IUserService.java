package com.example.security.service;

import com.example.security.payload.request.RegisterRequest;
import com.example.security.payload.response.RegisterResponse;

public interface IUserService {

    RegisterResponse save(RegisterRequest registerRequest);

    boolean checkUserNameOrExist(String username, String email);

}
