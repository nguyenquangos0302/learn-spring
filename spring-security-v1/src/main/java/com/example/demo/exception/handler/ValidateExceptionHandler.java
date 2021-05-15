package com.example.demo.exception.handler;

import com.example.demo.payload.response.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidateExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> validateException(MethodArgumentNotValidException e, WebRequest webRequest) {
        // 1. Create payload containing exception details
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Map<String, String> fieldErrors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            fieldErrors.put(fieldName, errorMessage);
        });

        String path = webRequest.getDescription(false).substring(4);

        ExceptionResponse exceptionResponse = ExceptionResponse
                                                                .builder()
                                                                .timestamp(timestamp.getTime())
                                                                .statusCode(HttpStatus.BAD_REQUEST.value())
                                                                .errors(fieldErrors)
                                                                .path(path)
                                                                .build();

        // 2. Return response entity
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
