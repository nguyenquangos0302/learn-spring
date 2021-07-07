package com.example.demo.service.impl;

import com.example.demo.constant.MessageConstant;
import com.example.demo.entity.Role;
import com.example.demo.enums.ERole;
import com.example.demo.exception.message.RoleException;
import com.example.demo.payload.response.role.RoleResponse;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.service.IRoleService;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleService implements IRoleService {

    private static final Logger LOGGER = Logger.getLogger(RoleService.class.getName());

    private final IRoleRepository roleRepository;

    private final ModelMapper modelMapper;

    @Override
    public RoleResponse findByName(ERole name) {
        try {
            LOGGER.info("[findByName] -> execute");
            Optional<Role> role = roleRepository.findByName(name);
            if (role.isPresent()) {
                RoleResponse roleResponse = modelMapper.map(role.get(), RoleResponse.class);
                return roleResponse;
            } else {
                throw new RoleException(MessageConstant.ROLE_NOT_FOUND);
            }
        } catch (RoleException e) {
            LOGGER.error("[findByName] -> fail. Role is not exist in system");
            throw new RoleException(MessageConstant.ROLE_NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error("[findByName] -> fail. Error is not identify. Message: " + e.getMessage());
            throw new RuntimeException();
        }

    }
}
