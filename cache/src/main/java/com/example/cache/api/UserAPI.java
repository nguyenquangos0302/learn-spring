package com.example.cache.api;

import com.example.cache.entity.User;
import com.example.cache.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserAPI {

    @Autowired
    public IUserService userService;

    @GetMapping("")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/user1")
    public List<User> findAll1() {
        return userService.findAll1();
    }

    @GetMapping("/caching")
    public void clear() {
        userService.clearCaching();
    }

    @GetMapping("/user")
    public User findById(@RequestParam int id) {
        return userService.findById(id);
    }

    @GetMapping("/caching/id")
    public void cachingid(@RequestParam int id) {
        userService.clearCachingId(id);
    }

    @GetMapping("/caching/all")
    public void cachingAllId() {
        userService.clearAllCaching();
    }

    @GetMapping("/update")
    public void update(@RequestParam int id) {
        userService.update(id);
    }

}
