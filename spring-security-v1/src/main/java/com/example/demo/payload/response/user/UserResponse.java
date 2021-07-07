package com.example.demo.payload.response.user;

import com.example.demo.payload.response.role.RoleResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {

    private String id;

    private String name;

    private String username;

    private String email;

    private Set<RoleResponse> listRole = new HashSet<RoleResponse>();

}
