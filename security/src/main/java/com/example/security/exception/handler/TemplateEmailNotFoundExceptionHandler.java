package com.example.security.exception.handler;

import com.example.security.dto.ExceptionDTO;
import com.example.security.exception.message.TemplateEmailNotFoundExceptionMessage;
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
public class TemplateEmailNotFoundExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(TemplateEmailNotFoundExceptionHandler.class.getName());

    @ExceptionHandler(value = {TemplateEmailNotFoundExceptionMessage.class})
    public ResponseEntity<ObjectResult<ExceptionDTO>> handlerTemplateEmailNotFoundException(TemplateEmailNotFoundExceptionMessage e, WebRequest webRequest) {
        String pathWebRequest = webRequest.getDescription(false);
        LOGGER.error(">>>>> [" + pathWebRequest + "] --> execute fail. <<<<<");
        LOGGER.info("==================== START HANDLER TEMPLATE NOT FOUND EXCEPTION PROCESS ===================");
        LOGGER.warn(">>>>> [handlerTemplateEmailNotFoundException] --> EXECUTE PROCESS");


        String path = webRequest.getDescription(false).substring(4);

        ObjectResult<ExceptionDTO> objectResult = new ObjectResult<>();

        objectResult.setTimestamp(TimeStampUtil.getInstance().getCurrentTimeStamp());
        objectResult.setStatus(HttpStatus.SERVICE_UNAVAILABLE);
        objectResult.setStatusCode(HttpStatus.SERVICE_UNAVAILABLE.value());
        objectResult.setMessage(e.getMessage());
        objectResult.setPath(path);

        LOGGER.info("ObjectResult: " + objectResult.toString());
        LOGGER.warn("[handlerTemplateEmailNotFoundException] --> FINISH PROCESS <<<<<");
        LOGGER.info("[==================== END HANDLER TEMPLATE NOT FOUND EXCEPTION PROCESS ===================]");
        return new ResponseEntity<ObjectResult<ExceptionDTO>>(objectResult, HttpStatus.SERVICE_UNAVAILABLE);
    }

}
