package com.example.twillio.intializer;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitializer {

    public String ACCOUNT_SID = "AC023d3d1fe0d131d15b8af59c60aeca1f";

    public String AUTH_TOKEN = "b3099486bbd096f9befd33f93b08adf6";

    @Autowired
    public TwilioInitializer() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

}
