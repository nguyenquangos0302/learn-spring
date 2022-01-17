package com.example.security.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class GenerateConfirmUUIDUtil {

    private static final Logger LOGGER = LogManager.getLogger(GenerateConfirmUUIDUtil.class.getName());

    private static GenerateConfirmUUIDUtil instance;

    private GenerateConfirmUUIDUtil() {

    }

    public static GenerateConfirmUUIDUtil getInstance() {
        LOGGER.info("==================== START GENERATE CONFIRM UTIL PROCESS ===================");
        LOGGER.warn(">>>>> [GenerateConfirmUtil] --> EXECUTE PROCESS");
        if (instance == null) {
            instance = new GenerateConfirmUUIDUtil();
        }
        LOGGER.info("GenerateConfirmUtil Instance: " + instance);
        LOGGER.warn("[GenerateConfirmUtil] --> FINISH PROCESS <<<<<");
        return instance;
    }

    public String getGenerateConfirm() {
        LOGGER.warn(">>>>> [getGenerateConfirm] --> EXECUTE PROCESS");
        String confirm = UUID.randomUUID().toString();
        LOGGER.info("Confirm: " + confirm);
        LOGGER.warn("[getGenerateConfirm] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END GENERATE CONFIRM UTIL PROCESS ===================");
        return confirm;
    }

}
