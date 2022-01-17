package com.example.security.service.impl;

import com.example.security.constant.MessageConstant;
import com.example.security.constant.TwilioConstant;
import com.example.security.exception.message.SystemExceptionMessage;
import com.example.security.service.ITwilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class TwilioService implements ITwilio {
    private static final Logger LOGGER = LogManager.getLogger(TwilioService.class.getName());

    @Override
    public void sendSMS(String phone, String message) {
        LOGGER.info("==================== START TWILIO SERVICE PROCESS ===================");
        LOGGER.warn(">>>>> [sendSMS] --> EXECUTE PROCESS");
        try {
            PhoneNumber to = new PhoneNumber(phone);
            PhoneNumber from = new PhoneNumber(TwilioConstant.TRAIL_NUMBER);
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.warn("[sendSMS] --> FINISH PROCESS <<<<<");
            LOGGER.info("==================== END TWILIO SERVICE PROCESS ===================");
        } catch (Exception e) {
            LOGGER.error(">>>>> REASON generateConfirm EXECUTE FAIL: " + e.getMessage() + " <<<<<");
            throw new SystemExceptionMessage(MessageConstant.SYSTEM_ERROR);
        }
    }
}
