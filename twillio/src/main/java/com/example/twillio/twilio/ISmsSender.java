package com.example.twillio.twilio;

import com.example.twillio.model.SmsRequest;
import org.springframework.stereotype.Service;

public interface ISmsSender {

    void sendSMS(SmsRequest smsRequest);

}
