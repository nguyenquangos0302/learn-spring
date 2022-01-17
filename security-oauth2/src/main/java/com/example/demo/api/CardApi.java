package com.example.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myCard")
public class CardApi {

    @GetMapping("")
    public String getCard() {
        return "My Card";
    }

}
