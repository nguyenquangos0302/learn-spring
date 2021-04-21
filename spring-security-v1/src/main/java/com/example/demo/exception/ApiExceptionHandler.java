package com.example.demo.exception;

import com.example.demo.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<Object> handlerApiRequestException(MethodArgumentNotValidException e) {
        // 1. Create payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ExceptionResponse exceptionResponse = new ExceptionResponse(e.getBindingResult().getFieldError().getDefaultMessage(), badRequest, ZonedDateTime.now(ZoneId.of("Z")));
        // 2. Return response entity
        return new ResponseEntity<Object>(exceptionResponse, badRequest);
    }

}
