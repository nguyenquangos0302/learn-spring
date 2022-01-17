package com.example.security.exception.handler;

import com.example.security.dto.ExceptionDTO;
import com.example.security.exception.message.SystemExceptionMessage;
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
public class SystemExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(SystemExceptionHandler.class.getName());

    @ExceptionHandler(value = {SystemExceptionMessage.class})
    public ResponseEntity<ObjectResult<ExceptionDTO>> handlerSystemException(SystemExceptionMessage e, WebRequest webRequest) {
        String pathWebRequest = webRequest.getDescription(false);
        LOGGER.error(">>>>> [" + pathWebRequest + "] --> execute fail. <<<<<");
        LOGGER.info("==================== START HANDLER SYSTEM EXCEPTION PROCESS ===================");
        LOGGER.warn(">>>>> [handlerSystemException] --> EXECUTE PROCESS");

        String path = webRequest.getDescription(false).substring(4);

        ObjectResult<ExceptionDTO> objectResult = new ObjectResult<>();

        objectResult.setTimestamp(TimeStampUtil.getInstance().getCurrentTimeStamp());
        objectResult.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        objectResult.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        objectResult.setMessage(e.getMessage());
        objectResult.setPath(path);

        LOGGER.info("ObjectResult: " + objectResult.toString());
        LOGGER.warn("[handlerSystemException] --> FINISH PROCESS <<<<<");
        LOGGER.info("[==================== END HANDLER SYSTEM EXCEPTION PROCESS ===================]");
        return new ResponseEntity<ObjectResult<ExceptionDTO>>(objectResult, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
