package com.example.security.service;

import java.util.Map;

public interface IEmailService {

    void sendEmail(String email, Map<String, Object> model, String subject);

}
