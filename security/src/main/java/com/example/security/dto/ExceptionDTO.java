package com.example.security.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, String> errors;

}
