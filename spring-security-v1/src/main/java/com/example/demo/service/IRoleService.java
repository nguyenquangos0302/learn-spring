package com.example.demo.service;

import com.example.demo.enums.ERole;
import com.example.demo.payload.response.role.RoleResponse;
import org.springframework.stereotype.Service;

@Service
public interface IRoleService {

    RoleResponse findByName(ERole name);

}
