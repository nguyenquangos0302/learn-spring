package com.example.security.validator.impl;

import com.example.security.exception.message.PhoneNumberExceptionMessage;
import com.example.security.payload.request.PhoneNumberRequest;
import com.example.security.validator.APhoneNumberValidator;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Configuration
public class PhoneNumberValidator implements ConstraintValidator<APhoneNumberValidator, PhoneNumberRequest> {

    private static final Logger LOGGER = LogManager.getLogger(PhoneNumberValidator.class.getName());

    @Override
    public void initialize(APhoneNumberValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(PhoneNumberRequest phoneNumberRequest, ConstraintValidatorContext context) {
        LOGGER.info("==================== START VALIDATOR PHONE NUMBER PROCESS ===================");
        LOGGER.warn(">>>>> [isValid] --> EXECUTE PROCESS");
        if (phoneNumberRequest == null) {
            return false;
        }
        if (phoneNumberRequest.getNumber() == null || phoneNumberRequest.getRegion() == null) {
            return false;
        }
        try {
            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
            LOGGER.info("PHONE NUMBER: " + phoneNumberRequest.getNumber() + ", REGION: " + phoneNumberRequest.getRegion());
            LOGGER.warn("[isValid] --> FINISH PROCESS <<<<<");
            LOGGER.info("==================== END VALIDATOR PHONE NUMBER PROCESS ===================");
            return phoneNumberUtil.isValidNumber(phoneNumberUtil.parse(phoneNumberRequest.getNumber(), phoneNumberRequest.getRegion()));
        } catch (NumberParseException e) {
            throw new PhoneNumberExceptionMessage(e.getMessage());
        }
    }
}
