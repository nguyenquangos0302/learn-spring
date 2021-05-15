package com.example.demo.service.impl;

import com.example.demo.entity.Role;
import com.example.demo.enums.ERole;
import com.example.demo.payload.response.role.RoleResponse;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.service.IRoleService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleService implements IRoleService {

    private final IRoleRepository roleRepository;

    private final ModelMapper modelMapper;

    @Override
    public RoleResponse findByName(ERole name) {
        try {
            Optional<Role> role = roleRepository.findByName(name);
            if (role.isPresent()) {
                RoleResponse roleResponse = modelMapper.map(role.get(), RoleResponse.class);
                return roleResponse;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("DB error");
        }

    }
}
