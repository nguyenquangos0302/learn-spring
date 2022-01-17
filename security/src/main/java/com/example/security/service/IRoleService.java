package com.example.security.service;

import com.example.security.enums.ERole;
import com.example.security.payload.response.RoleResponse;

public interface IRoleService {

    RoleResponse findByName(ERole name);

}
