package com.example.demo.service;

import com.example.demo.request.RegistrationRequest;
import com.example.demo.response.RegistrationResponse;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    RegistrationResponse save(RegistrationRequest registrationRequest) throws Exception;

}
