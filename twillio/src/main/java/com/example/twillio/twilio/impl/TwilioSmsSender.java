package com.example.twillio.twilio.impl;

import com.example.twillio.model.SmsRequest;
import com.example.twillio.twilio.ISmsSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsSender implements ISmsSender {

    public String TRAIL_NUMBER = "+14124192729";

    @Override
    public void sendSMS(SmsRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(TRAIL_NUMBER);
            String message = smsRequest.getMessage();

            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
        } else {
            throw new IllegalArgumentException("Phone number [" + smsRequest.getPhoneNumber() + "] is not a valid number");
        }
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        //TODO:
        return true;
    }

}
