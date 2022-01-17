package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MethodArgumentNotValidExceptionModel {

    private Long timestamp;

    private int statusCode;

    private Map<String, String> errors;

}
