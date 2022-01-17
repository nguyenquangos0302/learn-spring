package com.example.security.utils;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GsonUtil {

    private static final Logger LOGGER = LogManager.getLogger(GsonUtil.class.getName());

    private static GsonUtil instance;

    private Gson gson = new Gson();

    private GsonUtil() {
    }

    public static GsonUtil getInstance() {
        LOGGER.info("==================== START GSON UTIL PROCESS ===================");
        LOGGER.warn(">>>>> [getInstance] --> EXECUTE PROCESS");
        if (instance == null) {
            instance = new GsonUtil();
        }
        LOGGER.info("GsonUtil Instance: " + instance);
        LOGGER.warn("[getInstance] --> FINISH PROCESS <<<<<");
        return instance;
    }

    public String convertJsonToString(Object object) {
        LOGGER.warn(">>>>> [convertJsonToString] --> EXECUTE PROCESS");
        String convert = gson.toJson(object);
        LOGGER.info("Json Convert String: " + convert);
        LOGGER.warn("[convertJsonToString] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END GSON UTIL PROCESS ===================");
        return convert;
    }

}
