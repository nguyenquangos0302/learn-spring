package com.example.demo.exception.handler;

import com.example.demo.constant.MessageConstant;
import com.example.demo.payload.response.ObjectResult;
import com.example.demo.payload.response.exception.ExceptionResponse;
import com.example.demo.utils.TimeStampUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidateExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ObjectResult<ExceptionResponse>> handlerValidateException(MethodArgumentNotValidException e, WebRequest webRequest) {
        // 1. Create payload containing exception details

        Map<String, String> fieldErrors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            fieldErrors.put(fieldName, errorMessage);
        });

        String path = webRequest.getDescription(false).substring(4);

        ExceptionResponse exceptionResponse = ExceptionResponse
                                                                .builder()
                                                                .errors(fieldErrors)
                                                                .build();

        ObjectResult<ExceptionResponse> objectResult = new ObjectResult<>();

        objectResult.setTimestamp(TimeStampUtils.getTimeStamp());
        objectResult.setStatus(HttpStatus.BAD_REQUEST);
        objectResult.setStatusCode(HttpStatus.BAD_REQUEST.value());
        objectResult.setMessage(MessageConstant.VALIDATE_ERROR);
        objectResult.setObject(exceptionResponse);
        objectResult.setPath(path);

        // 2. Return response entity
        return new ResponseEntity<ObjectResult<ExceptionResponse>>(objectResult, HttpStatus.BAD_REQUEST);
    }

}
