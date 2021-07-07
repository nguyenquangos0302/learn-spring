package com.example.demo.payload.response.exception;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Map;


@Builder
@Getter
public class ExceptionResponse implements Serializable{

    private Map<String, String> errors;

}
