package com.example.security.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Please provider a number")
    private String number;

    @NotBlank(message = "Please provider a region")
    private String region;

}
