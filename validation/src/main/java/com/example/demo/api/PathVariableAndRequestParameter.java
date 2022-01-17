package com.example.demo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api/v1")
@Validated
public class PathVariableAndRequestParameter {

    @GetMapping("/validatePathVariable/{id}")
    ResponseEntity<String> validatePathVariable(
            @PathVariable("id") int id) {
        return ResponseEntity.ok("valid");
    }

    @GetMapping("/validateRequestParameter")
    ResponseEntity<String> validateRequestParameter(
            @RequestParam("param") @Min(5) int param) {
        return ResponseEntity.ok("valid");
    }

}
