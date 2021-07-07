package com.example.demo.payload.request.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationRequest implements Serializable {

    @NotBlank(message = "Please provider a name")
    @Size(min = 5, max = 20, message = "Name length must be from 5 to 20 characters")
    private String name;

    @NotBlank(message = "Please provider a username")
    @Size(min = 5, max = 20, message = "UserName length must be from 5 to 20 characters")
    private String username;

    @NotBlank(message = "Please provider a password")
    private String password;

    @NotBlank(message = "Please provider a email")
    @Size(min = 5, max = 100, message = "Email length must be from 5 to 100 characters")
    @Email(message = "Email should be valid")
    private String email;

    private Set<String> roles;

}
