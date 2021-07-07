package com.example.auditing.api;

import com.example.auditing.auditing.AuditorAwareImpl;
import com.example.auditing.entity.User;
import com.example.auditing.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class UserAPI {

    private final IUserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {
        List<User> listUser = userService.findAll();
        return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
    }

    @PostMapping("/users")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

}
