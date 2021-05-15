package com.example.demo.payload.response.user;

import com.example.demo.payload.response.role.RoleResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationResponse implements Serializable {

    private UUID id;

    private String name;

    private String username;

    private String email;

    private Set<RoleResponse> listRole = new HashSet<RoleResponse>();

}
