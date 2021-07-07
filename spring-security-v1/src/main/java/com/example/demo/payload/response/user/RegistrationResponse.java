package com.example.demo.payload.response.user;

import com.example.demo.payload.response.role.RoleResponse;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegistrationResponse implements Serializable {

    private String id;

    private String name;

    private String username;

    private String email;

    private Set<RoleResponse> listRole = new HashSet<RoleResponse>();

}
