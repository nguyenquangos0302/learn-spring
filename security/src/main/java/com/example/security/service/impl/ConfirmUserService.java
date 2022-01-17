package com.example.security.service.impl;

import com.example.security.constant.MessageConstant;
import com.example.security.entity.ConfirmUser;
import com.example.security.exception.message.SystemExceptionMessage;
import com.example.security.repository.IConfirmUserRepository;
import com.example.security.service.IConfirmUserService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ConfirmUserService implements IConfirmUserService {

    private final IConfirmUserRepository iConfirmUserRepository;

    private static final Logger LOGGER = LogManager.getLogger(ConfirmUserService.class.getName());

    @Override
    @Transactional
    public void generateConfirm(ConfirmUser confirmUser) {
        LOGGER.info("==================== START CONFIRM USER SERVICE PROCESS ===================");
        LOGGER.warn(">>>>> [generateConfirm] --> EXECUTE PROCESS");
        try {
            iConfirmUserRepository.save(confirmUser);
            LOGGER.warn("[generateConfirm] --> FINISH PROCESS <<<<<");
            LOGGER.info("==================== END ROLE SERVICE PROCESS ===================");
        } catch (Exception e) {
            LOGGER.error(">>>>> REASON generateConfirm EXECUTE FAIL: " + e.getMessage() + " <<<<<");
            throw new SystemExceptionMessage(MessageConstant.SYSTEM_ERROR);
        }
    }
}
