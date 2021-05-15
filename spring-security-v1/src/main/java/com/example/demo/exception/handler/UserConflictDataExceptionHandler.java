package com.example.demo.exception.handler;

import com.example.demo.exception.message.UserException;
import com.example.demo.payload.response.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserConflictDataExceptionHandler {

    @ExceptionHandler(value = {UserException.class})
    public ResponseEntity<Object> handlerUserException(UserException e, WebRequest webRequest) {
        // 1. Create payload containing exception details
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Map<String, String> messageError = new HashMap<>();
        messageError.put("message", e.getMessage());

        String path = webRequest.getDescription(false).substring(4);

        ExceptionResponse exceptionResponse = ExceptionResponse
                .builder()
                .timestamp(timestamp.getTime())
                .statusCode(HttpStatus.CONFLICT.value())
                .errors(messageError)
                .path(path)
                .build();

        // 2. Return response entity
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.CONFLICT);
    }

}
