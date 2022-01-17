package com.example.security.service.impl;

import com.example.security.config.mapper.ModelMapperConfig;
import com.example.security.constant.MessageConstant;
import com.example.security.entity.Role;
import com.example.security.enums.ERole;
import com.example.security.exception.message.DataNotFoundExceptionMessage;
import com.example.security.exception.message.SystemExceptionMessage;
import com.example.security.payload.response.RoleResponse;
import com.example.security.repository.IRoleRepository;
import com.example.security.service.IRoleService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleService implements IRoleService {

    private static final Logger LOGGER = LogManager.getLogger(UserService.class.getName());

    private final IRoleRepository iRoleRepository;

    private final ModelMapperConfig modelMapperConfig;

    @Override
    public RoleResponse findByName(ERole name) {
        LOGGER.info("==================== START ROLE SERVICE PROCESS ===================");
        LOGGER.warn(">>>>> [findByName] --> EXECUTE PROCESS");
        try {
            Optional<Role> role = iRoleRepository.findByName(name);
            if (role.isPresent()) {
                RoleResponse roleResponse = modelMapperConfig.modelMapper().map(role.get(), RoleResponse.class);
                LOGGER.warn("ROLE: " + roleResponse.toString());
                LOGGER.warn("[findByName] --> FINISH PROCESS <<<<<");
                LOGGER.info("==================== END ROLE SERVICE PROCESS ===================");
                return roleResponse;
            } else {
                throw new DataNotFoundExceptionMessage(MessageConstant.ROLE_NOT_FOUND);
            }
        } catch (DataNotFoundExceptionMessage e) {
            LOGGER.error(">>>>> REASON findByName EXECUTE FAIL: " + e.getMessage() + " <<<<<");
            throw new DataNotFoundExceptionMessage(MessageConstant.ROLE_NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error(">>>>> REASON findByName EXECUTE FAIL: " + e.getMessage() + " <<<<<");
            throw new SystemExceptionMessage(MessageConstant.SYSTEM_ERROR);
        }

    }
}
