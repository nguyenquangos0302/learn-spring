package com.bharath.spring.security.firstapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class FirstappApplicationTests {

    @Test
    void contextLoads() {

        Map<String, PasswordEncoder> encoderMap = new HashMap<>();
        encoderMap.put("bcrypy", new BCryptPasswordEncoder());

        System.out.println(new DelegatingPasswordEncoder("bcrypy", encoderMap).encode("password"));

    }

}
