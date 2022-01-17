package com.example.security.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmailUtil {

    private static final Logger LOGGER = LogManager.getLogger(EmailUtil.class.getName());

    private static EmailUtil instance;

    private EmailUtil() {

    }

    public static EmailUtil getInstance() {
        LOGGER.info("==================== START GENERATE CONFIRM UTIL PROCESS ===================");
        LOGGER.warn(">>>>> [EmailUtil] --> EXECUTE PROCESS");
        if (instance == null) {
            instance = new EmailUtil();
        }
        LOGGER.info("EmailUtil Instance: " + instance);
        LOGGER.warn("[EmailUtil] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END GENERATE CONFIRM UTIL PROCESS ===================");
        return instance;
    }

    public String templateEmail(String name, String link) {
        LOGGER.warn(">>>>> [templateEmail] --> EXECUTE PROCESS");
        String template = "<p>Hi " + name + "</p>"
                + "Thank you for registering. Please click on the below link to activate your account:"
                + "<a href=\"" + link + "\">Active Now </a>";
        LOGGER.info("TEMPLATE: " + template);
        LOGGER.warn("[templateEmail] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END GENERATE CONFIRM UTIL PROCESS ===================");
        return template;
    }

}
