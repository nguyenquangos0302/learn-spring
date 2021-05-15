package com.example.demo.service.impl;

import com.example.demo.constant.MessageConstant;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.enums.ERole;
import com.example.demo.exception.message.RoleException;
import com.example.demo.exception.message.UserException;
import com.example.demo.payload.response.role.RoleResponse;
import com.example.demo.payload.response.user.UserResponse;
import com.example.demo.repository.IUserRepository;
import com.example.demo.payload.request.user.RegistrationRequest;
import com.example.demo.payload.response.user.RegistrationResponse;
import com.example.demo.service.IRoleService;
import com.example.demo.service.IUserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    private final ModelMapper modelMapper;

    private final IRoleService roleService;

    @Override
    @Transactional
    public RegistrationResponse save(RegistrationRequest registrationRequest) {
        try {
            UserResponse userByUserName = findUserByUserName(registrationRequest.getUsername());
            if (userByUserName != null ) {
                throw new UserException(MessageConstant.USERNAME_EXIST);
            }

            UserResponse userByEmail = findUserByEmail(registrationRequest.getEmail());
            if (userByEmail != null) {
                throw new UserException(MessageConstant.EMAIL_EXIST);
            }

            Set<String> listRoles = registrationRequest.getRoles();
            Set<Role> roles = new HashSet<Role>();

            if (listRoles == null || listRoles.size() <= 0) {
                Role role = new Role();
                role = findRoleByName(ERole.CUSTOMER);
                roles.add(role);
            } else {
                listRoles.forEach(role -> {
                    switch (role) {
                        case "ADMIN": RoleResponse roleAdmin = roleService.findByName(ERole.ADMIN); break;
                        case "DRIVER": break;
                        case "CUSTOMER": break;
                        case "GUEST": break;
                        default: break;
                    }
                });
            }


            return null;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Role findRoleByName(ERole name) {
        try {
            RoleResponse roleResponse = roleService.findByName(ERole.CUSTOMER);
            if (roleResponse != null) {
                Role role = new Role();
                role = modelMapper.map(roleResponse, Role.class);
                return role;
            } else {
                throw new RoleException(MessageConstant.ROLE_NOT_FOUND);
            }
        } catch (RoleException e) {
            throw new RoleException(MessageConstant.ROLE_NOT_FOUND);
        } catch (Exception e) {
            throw new RuntimeException("Model mapper error");
        }
    }

    @Override
    public UserResponse findUserByUserName(String username) {
        try {
            Optional<User> userOptional = userRepository.findUserByUsername(username);
            if (userOptional.isPresent()) {
                UserResponse userResponse = modelMapper.map(userOptional, UserResponse.class);
                return userResponse;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("DB errors");
        }
    }

    @Override
    public UserResponse findUserByEmail(String email) {
        try {
            Optional<User> userOptional = userRepository.findUserByEmail(email);
            if (userOptional.isPresent()) {
                UserResponse userResponse = modelMapper.map(userOptional, UserResponse.class);
                return userResponse;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("DB errors");
        }
    }
}
