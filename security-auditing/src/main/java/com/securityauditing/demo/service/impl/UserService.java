package com.securityauditing.demo.service.impl;

import com.securityauditing.demo.entity.UserEntity;
import com.securityauditing.demo.repository.IUserRepository;
import com.securityauditing.demo.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}
