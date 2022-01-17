package com.example.security.exception.handler;

import com.example.security.dto.ExceptionDTO;
import com.example.security.exception.message.SendMailExceptionMessage;
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
public class SendMailExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(SendMailExceptionMessage.class.getName());

    @ExceptionHandler(value = {SendMailExceptionMessage.class})
    public ResponseEntity<ObjectResult<ExceptionDTO>> handlerSendMailException(SendMailExceptionMessage e, WebRequest webRequest) {
        String pathWebRequest = webRequest.getDescription(false);
        LOGGER.error(">>>>> [" + pathWebRequest + "] --> execute fail. <<<<<");
        LOGGER.info("==================== START HANDLER SEND MAIL EXCEPTION PROCESS ===================");
        LOGGER.warn(">>>>> [handlerSendMailException] --> EXECUTE PROCESS");

        String path = webRequest.getDescription(false).substring(4);

        ObjectResult<ExceptionDTO> objectResult = new ObjectResult<>();

        objectResult.setTimestamp(TimeStampUtil.getInstance().getCurrentTimeStamp());
        objectResult.setStatus(HttpStatus.BAD_REQUEST);
        objectResult.setStatusCode(HttpStatus.BAD_REQUEST.value());
        objectResult.setMessage(e.getMessage());
        objectResult.setPath(path);

        LOGGER.info("ObjectResult: " + objectResult.toString());
        LOGGER.warn("[handlerSendMailException] --> FINISH PROCESS <<<<<");
        LOGGER.info("[==================== END HANDLER SEND MAIL EXCEPTION PROCESS ===================]");
        return new ResponseEntity<ObjectResult<ExceptionDTO>>(objectResult, HttpStatus.BAD_REQUEST);
    }

}
