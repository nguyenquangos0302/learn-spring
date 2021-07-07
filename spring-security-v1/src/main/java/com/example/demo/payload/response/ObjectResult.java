package com.example.demo.payload.response;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObjectResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Timestamp timestamp;

    private HttpStatus status;

    private int statusCode;

    private String message;
    
    private T object;

    private List<T> objects;

    private String path;

}
