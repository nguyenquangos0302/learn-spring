package com.example.mockito.unit.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {

    @GetMapping("hello-world")
    public String helloWorld() {
        return "Hello World";
    }

}
