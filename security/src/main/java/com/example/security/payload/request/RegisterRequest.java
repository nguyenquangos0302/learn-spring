package com.example.security.payload.request;

import com.example.security.validator.APhoneNumberValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Please provider a name")
    @Size(min = 5, max = 20, message = "Name length must be from {min} to {max} characters")
    private String name;

    @NotBlank(message = "Please provider a username")
    @Size(min = 5, max = 20, message = "UserName length must be from {min} to {max} characters")
    private String username;

    @NotBlank(message = "Please provider a password")
    private String password;

    @NotBlank(message = "Please provider a email")
    @Size(min = 5, max = 100, message = "Email length must be from {min} to {max} characters")
    @Email(message = "Email should be valid")
    private String email;

    @APhoneNumberValidator(message = "Please enter a valid phone number")
    private PhoneNumberRequest phone;

    private List<String> roles;

}
