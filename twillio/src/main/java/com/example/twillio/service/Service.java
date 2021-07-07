package com.example.twillio.service;

import com.example.twillio.model.SmsRequest;
import com.example.twillio.twilio.ISmsSender;
import com.example.twillio.twilio.impl.TwilioSmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class Service {

    private final ISmsSender smsSender;

    @Autowired
    public Service(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(SmsRequest smsRequest) {
        smsSender.sendSMS(smsRequest);
    }

}
