package com.example.demo.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SomeException extends RuntimeException {

    @ExceptionHandler(value = {SomeException.class})
    public String handlerApiRequestException(SomeException e) {
        return e.getMessage();
    }

}
