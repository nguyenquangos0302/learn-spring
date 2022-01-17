package com.example.security.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ObjectResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Timestamp timestamp;

    private HttpStatus status;

    private int statusCode;

    private String message;

    private T object;

    private List<T> listObjects;

    private String path;

}
