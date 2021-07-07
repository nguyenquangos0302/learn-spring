package com.example.demo.exception.handler;

import com.example.demo.constant.MessageConstant;
import com.example.demo.exception.message.DataConflictException;
import com.example.demo.payload.response.ObjectResult;
import com.example.demo.payload.response.exception.ExceptionResponse;
import com.example.demo.utils.TimeStampUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserConflictDataExceptionHandler {

    @ExceptionHandler(value = {DataConflictException.class})
    public ResponseEntity<ObjectResult<ExceptionResponse>> handlerUserException(DataConflictException e, WebRequest webRequest) {
        // 1. Create payload containing exception details

        Map<String, String> messageError = new HashMap<>();
        messageError.put("message", e.getMessage());

        String path = webRequest.getDescription(false).substring(4);

        ExceptionResponse exceptionResponse = ExceptionResponse
                .builder()
                .errors(messageError)
                .build();

        ObjectResult<ExceptionResponse> objectResult = new ObjectResult<>();

        objectResult.setTimestamp(TimeStampUtils.getTimeStamp());
        objectResult.setStatus(HttpStatus.CONFLICT);
        objectResult.setStatusCode(HttpStatus.CONFLICT.value());
        objectResult.setMessage(MessageConstant.USERNAME_EMAIL_EXIST);
        objectResult.setObject(exceptionResponse);
        objectResult.setPath(path);

        // 2. Return response entity
        return new ResponseEntity<ObjectResult<ExceptionResponse>>(objectResult, HttpStatus.CONFLICT);
    }

}
