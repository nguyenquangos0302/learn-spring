package com.example.cache.service;

import com.example.cache.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    List<User> findAll();

    void clearCaching();

    List<User> findAll1();

    User findById(int id);

    void clearCachingId(int id);

    void clearAllCaching();

    User update(int id);
}
