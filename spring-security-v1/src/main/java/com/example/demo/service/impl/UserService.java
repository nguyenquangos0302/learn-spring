package com.example.demo.service.impl;

import com.example.demo.config.password.PasswordConfig;
import com.example.demo.constant.MessageConstant;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.enums.ERole;
import com.example.demo.exception.message.RoleException;
import com.example.demo.exception.message.DataConflictException;
import com.example.demo.exception.message.UserException;
import com.example.demo.payload.response.ObjectResult;
import com.example.demo.payload.response.role.RoleResponse;
import com.example.demo.payload.response.user.UserResponse;
import com.example.demo.repository.IUserRepository;
import com.example.demo.payload.request.user.RegistrationRequest;
import com.example.demo.payload.response.user.RegistrationResponse;
import com.example.demo.service.IRoleService;
import com.example.demo.service.IUserService;
import com.example.demo.utils.TimeStampUtils;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    private final IUserRepository userRepository;

    private final ModelMapper modelMapper;

    private final IRoleService roleService;

    private PasswordConfig passwordConfig;

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public ObjectResult<RegistrationResponse> save(RegistrationRequest registrationRequest) {
        LOGGER.info("[save] -> execute");
        if (checkUserNameOrEmailNotExist(registrationRequest)) {
            User userRegisted = saveUserRegister(registrationRequest);

            UserResponse userResponse = findUserById(userRegisted.getId()).getObject();

            RegistrationResponse registrationResponse = modelMapper.map(userResponse, RegistrationResponse.class);

            ObjectResult<RegistrationResponse> objectResult = new ObjectResult<>();
            objectResult.setTimestamp(TimeStampUtils.getTimeStamp());
            objectResult.setStatus(HttpStatus.CREATED);
            objectResult.setStatusCode(HttpStatus.CREATED.value());
            objectResult.setMessage(MessageConstant.USER_REGISTER_SUCCESS);
            objectResult.setObject(registrationResponse);
            return objectResult;
        }
        ObjectResult<RegistrationResponse> objectResult = new ObjectResult<>();
        return objectResult;
    }

    private User saveUserRegister(RegistrationRequest registrationRequest) {
        try {
            LOGGER.info("[saveUserRegister] -> execute");
            Set<Role> roles = setListRoleForUserRegister(registrationRequest.getRoles());
            registrationRequest.setPassword(hashBcryptPassword(registrationRequest.getPassword()));
            User userRegister = new User();
            userRegister = modelMapper.map(registrationRequest, User.class);
            userRegister.setRoles(roles);
            userRegister.setCreatedBy(registrationRequest.getUsername());
            userRegister.setModifiedBy(registrationRequest.getUsername());
            return userRepository.save(userRegister);
        } catch (RoleException e) {
            LOGGER.error("[saveUserRegister] -> fail. Role not found. Message: " + e.getMessage());
            throw new RoleException(MessageConstant.ROLE_NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error("[saveUserRegister] -> fail. Error is not identify. Message: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    private String hashBcryptPassword(String password) {
        return passwordConfig.passwordEncoder().encode(password);
    }

    private boolean checkUserNameOrEmailNotExist(RegistrationRequest registrationRequest) {
        try {
            LOGGER.info("[checkUserNameOrEmailExist] -> execute");
            if (!userRepository.existsByUsernameOrEmail(registrationRequest.getUsername(), registrationRequest.getEmail())) {
                return true;
            } else {
                throw new DataConflictException(MessageConstant.USERNAME_EMAIL_EXIST);
            }
        } catch (DataConflictException e) {
            LOGGER.error("[checkUserNameOrEmailExist] -> fail. Username or email is exist. Message: " + e.getMessage());
            throw new DataConflictException(MessageConstant.USERNAME_EMAIL_EXIST);
        } catch (Exception e) {
            LOGGER.error("[checkUserNameOrEmailExist] -> fail. Error is not identify. Message: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    private Set<Role> setListRoleForUserRegister(Set<String> listRoleInRequestRegister) {
        LOGGER.info("[setListRoleForUserRegister] -> execute");
        Set<Role> roles = new HashSet<Role>();
        if (listRoleInRequestRegister == null || listRoleInRequestRegister.size() <= 0) {
            Role roleEntity = new Role();
            roleEntity = findRoleByName(ERole.USER);
            roles.add(roleEntity);
        } else {
            listRoleInRequestRegister.forEach(role -> {
                roles.add(identifyRole(role));
            });
        }
        return roles;
    }

    private Role identifyRole(String role) {
        try {
            LOGGER.info("[identifyRole] -> execute");
            Role roleEntity = new Role();
            switch (role) {
                case "ADMIN":
                    RoleResponse roleAdminFind = roleService.findByName(ERole.ADMIN);
                    roleEntity = modelMapper.map(roleAdminFind, Role.class);
                    break;
                case "DRIVER":
                    RoleResponse roleDriverFind = roleService.findByName(ERole.DRIVER);
                    roleEntity = modelMapper.map(roleDriverFind, Role.class);
                    break;
                case "USER":
                    RoleResponse roleCustomerFind = roleService.findByName(ERole.USER);
                    roleEntity = modelMapper.map(roleCustomerFind, Role.class);
                    break;
                case "GUEST":
                    RoleResponse roleGuestFind = roleService.findByName(ERole.GUEST);
                    roleEntity = modelMapper.map(roleGuestFind, Role.class);
                    break;
                default:
                    throw new RoleException(MessageConstant.ROLE_NOT_FOUND);
            }
            return roleEntity;
        } catch (RoleException e) {
            LOGGER.error("[identifyRole] -> fail. Role not found. Message: " + e.getMessage());
            throw new RoleException(MessageConstant.ROLE_NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error("[identifyRole] -> fail. Error is not identify. Message: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    private Role findRoleByName(ERole name) {
        LOGGER.info("[findRoleByName] -> execute");
        RoleResponse roleResponse = roleService.findByName(name);
        Role role = new Role();
        role = modelMapper.map(roleResponse, Role.class);
        return role;
    }

    @Override
    public ObjectResult<UserResponse> findUserByUserNameOrEmail(String username, String email) {
        try {
            LOGGER.info("[findUserByUserName] -> execute");
            ObjectResult<UserResponse> objectResult = new ObjectResult<>();
            Optional<User> userOptional = userRepository.findUserByUsernameOrEmail(username, email);
            if (userOptional.isPresent()) {
                UserResponse userResponse = modelMapper.map(userOptional.get(), UserResponse.class);
                objectResult.setTimestamp(TimeStampUtils.getTimeStamp());
                objectResult.setStatus(HttpStatus.OK);
                objectResult.setMessage(MessageConstant.USER_FIND);
                objectResult.setObject(userResponse);
                return objectResult;
            } else {
                throw new DataConflictException(MessageConstant.USERNAME_EMAIL_EXIST);
            }
        } catch(DataConflictException e) {
            LOGGER.error("[findUserByUserName] -> fail. Username or Email is exist.");
            throw new DataConflictException(MessageConstant.USERNAME_EMAIL_EXIST);
        } catch (Exception e) {
            LOGGER.error("[findUserByUserName] -> fail. Error is not identify. Message: " + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public ObjectResult<UserResponse> findUserById(String id) {
        try {
            LOGGER.info("[findUserById] -> execute");
            ObjectResult<UserResponse> objectResult = new ObjectResult<>();
            Optional<User> userOptional = userRepository.findUserById(id);
            if (userOptional.isPresent()) {
                UserResponse userResponse = modelMapper.map(userOptional.get(), UserResponse.class);

                Set<RoleResponse> listRole = getListRole(userOptional.get().getRoles());
                userResponse.setListRole(listRole);

                objectResult.setTimestamp(TimeStampUtils.getTimeStamp());
                objectResult.setStatus(HttpStatus.OK);
                objectResult.setMessage(MessageConstant.USER_FIND);
                objectResult.setObject(userResponse);
                return objectResult;
            } else {
                throw new UserException(MessageConstant.USER_NOT_FOUND);
            }
        } catch (UserException e) {
            LOGGER.error("[findUserById] -> fail. User is not exist in system");
            throw new UserException(MessageConstant.USER_NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error("[findUserById] -> fail. Error is not identify. Message: " + e.getMessage());
            throw new RuntimeException();
        }
    }

    private Set<RoleResponse> getListRole(Set<Role> listRole) {
        LOGGER.info("[getListRole] -> execute");
        Set<RoleResponse> list = new HashSet<>();
        listRole.forEach(role -> {
            RoleResponse roleResponse = new RoleResponse();
            roleResponse.setId(role.getId());
            roleResponse.setName(role.getName().name());
            list.add(roleResponse);
        });
        return list;
    }
}
