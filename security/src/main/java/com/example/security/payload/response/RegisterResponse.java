package com.example.security.payload.response;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RegisterResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String username;

    private String email;

    private Set<PhoneResponse> phones;

    private Set<RoleResponse> roles;

}
