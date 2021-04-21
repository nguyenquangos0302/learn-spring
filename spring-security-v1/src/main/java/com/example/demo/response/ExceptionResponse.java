package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionResponse {

    private String message;

    private HttpStatus httpStatus;

    private ZonedDateTime timestamp;

}
