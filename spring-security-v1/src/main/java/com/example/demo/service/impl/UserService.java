package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.request.RegistrationRequest;
import com.example.demo.response.RegistrationResponse;
import com.example.demo.service.IUserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    private final ModelMapper modelMapper;

    @Override
    public RegistrationResponse save(RegistrationRequest registrationRequest) throws Exception {
        User userRegistration = modelMapper.map(registrationRequest, User.class);
        User userOptional = userRepository.save(userRegistration);
        System.out.println(userRegistration.getName());
        return null;
    }
}
