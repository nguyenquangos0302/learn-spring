package com.example.demo.api;

import com.example.demo.entity.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.request.RegistrationRequest;
import com.example.demo.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserAPI {

    private final IUserService userService;

    private final IUserRepository userRepository;

    @PostMapping("/registration")
    public User registrationUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

//    @GetMapping("/list")
//    public List<User> listUser() {
//        return userRepository.findAll()
//    }


}
