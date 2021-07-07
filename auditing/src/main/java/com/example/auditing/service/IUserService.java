package com.example.auditing.service;

import com.example.auditing.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    List<User> findAll();

    User save(User user);

}
