package com.example.security.exception.handler;

import com.example.security.constant.MessageConstant;
import com.example.security.dto.ExceptionDTO;
import com.example.security.exception.message.PhoneNumberExceptionMessage;
import com.example.security.payload.ObjectResult;
import com.example.security.utils.TimeStampUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class PhoneNumberExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(PhoneNumberExceptionHandler.class.getName());

    @ExceptionHandler(value = {PhoneNumberExceptionMessage.class})
    public ResponseEntity<ObjectResult<ExceptionDTO>> handlerPhoneNumberException(PhoneNumberExceptionMessage e, WebRequest webRequest) {
        String pathWebRequest = webRequest.getDescription(false);
        LOGGER.error(">>>>> [" + pathWebRequest + "] --> EXECUTE FAIL. <<<<<");
        LOGGER.info("==================== START HANDLER PHONE NUMBER EXCEPTION PROCESS ===================]");
        LOGGER.warn(">>>>> [handlerPhoneNumberException] --> EXECUTE PROCESS");

        String path = webRequest.getDescription(false).substring(4);

        ObjectResult<ExceptionDTO> objectResult = new ObjectResult<>();

        objectResult.setTimestamp(TimeStampUtil.getInstance().getCurrentTimeStamp());
        objectResult.setStatus(HttpStatus.BAD_REQUEST);
        objectResult.setStatusCode(HttpStatus.BAD_REQUEST.value());
        objectResult.setMessage(MessageConstant.VALIDATE_ERROR);
        objectResult.setPath(path);

        LOGGER.info("ObjectResult: " + objectResult.toString());
        LOGGER.warn("[handlerPhoneNumberException] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END HANDLER PHONE NUMBER EXCEPTION PROCESS ===================");
        return new ResponseEntity<ObjectResult<ExceptionDTO>>(objectResult, HttpStatus.BAD_REQUEST);
    }

}
