package com.example.demo.exception;

import com.example.demo.model.MethodArgumentNotValidExceptionModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class NewException extends RuntimeException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        MethodArgumentNotValidExceptionModel exceptionModel = new MethodArgumentNotValidExceptionModel();

        exceptionModel.setTimestamp(timestamp.getTime());
        exceptionModel.setStatusCode(HttpStatus.BAD_REQUEST.value());

        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            fieldErrors.put(fieldName, errorMessage);
        });

        exceptionModel.setErrors(fieldErrors);

        return new ResponseEntity<Object>(exceptionModel, HttpStatus.BAD_REQUEST);
    }

}
