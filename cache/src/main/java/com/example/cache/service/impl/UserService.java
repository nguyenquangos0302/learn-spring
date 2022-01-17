package com.example.cache.service.impl;

import com.example.cache.entity.User;
import com.example.cache.repository.IUserRepository;
import com.example.cache.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    public IUserRepository iUserRepository;

    @Autowired
    CacheManager cacheManager;

    @Override
    @Cacheable("findAllUser")
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    @CacheEvict(value = "findAllUser", allEntries = true)
    public void clearCaching() {

    }

    @Override
    @Cacheable("findAllUser1")
    public List<User> findAll1() {
        return iUserRepository.findAll();
    }

    @Override
    @Cacheable("findById")
    public User findById(int id) {
        return iUserRepository.findById(id).orElse(null);
    }

    @Override
    @CacheEvict("findById")
    public void clearCachingId(int id) {

    }

    @Override
    @CacheEvict(value = "findById", allEntries = true)
    public void clearAllCaching() {
    }

    @Override
    @CachePut(value = "findById")
    public User update(int id) {
        User user = iUserRepository.findById(id).orElse(null);
        user.setName("ABC");
        return iUserRepository.save(user);
    }

}
