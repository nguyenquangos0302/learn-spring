package com.example.security.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;

public class TimeStampUtil {

    private static final Logger LOGGER = LogManager.getLogger(TimeStampUtil.class.getName());

    private static TimeStampUtil instance = null;

    private TimeStampUtil() {

    }

    public static TimeStampUtil getInstance() {
        LOGGER.info("==================== START TIME STAMP UTIL PROCESS ===================");
        LOGGER.warn(">>>>> [getInstance] --> EXECUTE PROCESS");
        if (instance == null) {
            instance = new TimeStampUtil();
        }
        LOGGER.info("TimeStampUtil Instance: " + instance);
        LOGGER.warn("[getCurrentTimeStamp] --> FINISH PROCESS <<<<<");
        return instance;
    }

    public Timestamp getCurrentTimeStamp() {
        LOGGER.warn(">>>>> [getCurrentTimeStamp] --> EXECUTE PROCESS");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        LOGGER.info("TimeStamp: " + timestamp);
        LOGGER.warn("[getCurrentTimeStamp] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END TIME STAMP UTIL PROCESS ===================");
        return timestamp;
    }

}
