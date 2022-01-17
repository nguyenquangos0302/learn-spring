package com.example.security.payload.response;

import com.example.security.enums.ERole;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RoleResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private ERole name;

}
