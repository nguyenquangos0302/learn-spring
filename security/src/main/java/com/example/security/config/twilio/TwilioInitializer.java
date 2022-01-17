package com.example.security.config.twilio;

import com.example.security.constant.TwilioConstant;
import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitializer {

    @Autowired
    public TwilioInitializer() {
        Twilio.init(TwilioConstant.ACCOUNT_SID, TwilioConstant.AUTH_TOKEN);
    }

}
