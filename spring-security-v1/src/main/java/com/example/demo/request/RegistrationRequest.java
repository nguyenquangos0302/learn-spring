package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationRequest {

    @NotBlank(message = "Please provider a name")
    @Size(min = 5, max = 20, message = "Name length must be from 5 to 20 characters")
    private String name;

    @NotBlank(message = "Please provider a username")
    @Size(min = 5, max = 20, message = "Name length must be from 5 to 20 characters")
    private String username;

    @NotBlank(message = "Please provider a password")
    private String password;

    @NotBlank(message = "Please provider a email")
    @Size(min = 5, max = 20, message = "Name length must be from 5 to 20 characters")
    @Email(message = "Email should be valid")
    private String email;
}
