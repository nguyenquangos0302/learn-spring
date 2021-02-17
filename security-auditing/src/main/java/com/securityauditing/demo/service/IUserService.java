package com.securityauditing.demo.service;

import com.securityauditing.demo.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    UserEntity save(UserEntity userEntity);

}
