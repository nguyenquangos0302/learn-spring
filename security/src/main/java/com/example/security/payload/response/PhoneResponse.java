package com.example.security.payload.response;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class PhoneResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String number;

    private String region;

}
