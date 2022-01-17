package com.example.security.service.impl;

import com.example.security.config.mapper.ModelMapperConfig;
import com.example.security.config.password.PasswordConfig;
import com.example.security.constant.EmailConstant;
import com.example.security.constant.MessageConstant;
import com.example.security.constant.PathConstant;
import com.example.security.entity.ConfirmUser;
import com.example.security.entity.Phone;
import com.example.security.entity.Role;
import com.example.security.entity.User;
import com.example.security.enums.ERole;
import com.example.security.exception.message.DataConflictExceptionMessage;
import com.example.security.exception.message.SystemExceptionMessage;
import com.example.security.payload.request.RegisterRequest;
import com.example.security.payload.response.RegisterResponse;
import com.example.security.payload.response.RoleResponse;
import com.example.security.repository.IUserRepository;
import com.example.security.service.IEmailService;
import com.example.security.service.IRoleService;
import com.example.security.service.IUserService;
import com.example.security.utils.GenerateConfirmUUIDUtil;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private static final Logger LOGGER = LogManager.getLogger(UserService.class.getName());

    private final IUserRepository iUserRepository;

    private final IRoleService iRoleService;

    private final ModelMapperConfig modelMapperConfig;

    private final PasswordConfig passwordConfig;

    private final IEmailService iEmailService;

    @Override
    @Transactional
    public RegisterResponse save(RegisterRequest registerRequest) {
        LOGGER.info("==================== START USER SERVICE PROCESS ===================");
        LOGGER.warn(">>>>> [save] --> EXECUTE PROCESS");
        if (!checkUserNameOrExist(registerRequest.getUsername(), registerRequest.getEmail())) {
            // Set Role
            Set<Role> listRole = new HashSet<>();
            if (registerRequest.getRoles().size() <= 0 || registerRequest.getRoles() == null) {
                registerRequest.setRoles(Lists.newArrayList("GUEST", "USER"));
            }
            listRole = setListRole(registerRequest.getRoles());

            // User Table
            User user = modelMapperConfig.modelMapper().map(registerRequest, User.class);
            Phone phone = modelMapperConfig.modelMapper().map(registerRequest.getPhone(), Phone.class);
            user.setRoles(listRole);
            user.setPassword(hashBcryptPassword(registerRequest.getPassword()));

            // Phone Table
            user.addPhoneNumber(phone);

            // Confirm User Table
            String code = GenerateConfirmUUIDUtil.getInstance().getGenerateConfirm();
            ConfirmUser confirmUser = new ConfirmUser();
            confirmUser.setCode(code);
            confirmUser.setExpiredDate(LocalDateTime.now().plusMinutes(15));
            user.addConfirm(confirmUser);

            user = iUserRepository.save(user);

            // Response
            RegisterResponse response = modelMapperConfig.modelMapper().map(user, RegisterResponse.class);

            // Generate Link Confirm
            String linkConfirm = PathConstant.PREFIX_PATH_CONFIRM_USER + PathConstant.PATH_CONFIRM_USER + code;

            // Send Mail
            Map<String, Object> mailData = new HashMap<>();
            mailData.put("name", user.getName());
            mailData.put("link", linkConfirm);
            iEmailService.sendEmail(user.getEmail(), mailData, EmailConstant.SUBJECT_EMAIL_REGISTRATION);

            LOGGER.warn("REGISTER RESPONSE: " + response.toString());
            LOGGER.warn("[save] --> FINISH PROCESS <<<<<");
            LOGGER.info("==================== END USER SERVICE PROCESS ===================");
            return response;
        }
        return null;
    }

    @Override
    public boolean checkUserNameOrExist(String username, String email) {
        LOGGER.info("==================== START USER SERVICE PROCESS ===================");
        LOGGER.warn(">>>>> [checkAccountOrEmailExist] --> EXECUTE PROCESS");
        try {
            if (iUserRepository.existsByUsernameOrEmail(username, email)) {
                throw new DataConflictExceptionMessage(MessageConstant.USERNAME_EMAIL_EXIST);
            }
            LOGGER.warn("IS USERNAME OR EMAIL EXIST: FALSE");
            LOGGER.warn("[checkAccountOrEmailExist] --> FINISH PROCESS <<<<<");
            LOGGER.info("==================== END USER SERVICE PROCESS ===================");
            return false;
        } catch (DataConflictExceptionMessage e) {
            LOGGER.error(">>>>> REASON checkUserNameOrExist EXECUTE FAIL: " + e.getMessage() + " <<<<<");
            throw new DataConflictExceptionMessage(MessageConstant.USERNAME_EMAIL_EXIST);
        } catch (Exception e) {
            LOGGER.error(">>>>> REASON checkUserNameOrExist EXECUTE FAIL: " + e.getMessage() + " <<<<<");
            throw new SystemExceptionMessage(MessageConstant.SYSTEM_ERROR);
        }
    }

    private Set<Role> setListRole(List<String> listRole) {
        LOGGER.info("==================== START USER SERVICE PROCESS ===================");
        LOGGER.warn(">>>>> [setListRole] --> EXECUTE PROCESS");
        Set<Role> roles = listRole.stream().map(roleData -> {
            RoleResponse roleResponse = iRoleService.findByName(ERole.valueOf(roleData));
            return modelMapperConfig.modelMapper().map(roleResponse, Role.class);
        }).collect(Collectors.toSet());
        LOGGER.warn("SIZE ROLE: " + roles.size());
        LOGGER.warn("[setListRole] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END USER SERVICE PROCESS ===================");
        return roles;
    }

    private String hashBcryptPassword(String password) {
        return passwordConfig.passwordEncoder().encode(password);
    }

}
