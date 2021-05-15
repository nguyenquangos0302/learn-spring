package com.example.demo.payload.model.user;

import com.example.demo.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel implements Serializable {

    private String name;

    private String username;

    private String password;

    private String email;

    private Set<Role> roles;

}
