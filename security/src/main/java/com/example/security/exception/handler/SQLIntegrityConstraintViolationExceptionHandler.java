package com.example.security.exception.handler;

import com.example.security.constant.MessageConstant;
import com.example.security.dto.ExceptionDTO;
import com.example.security.payload.ObjectResult;
import com.example.security.utils.TimeStampUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class SQLIntegrityConstraintViolationExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(SQLIntegrityConstraintViolationExceptionHandler.class.getName());

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ObjectResult<ExceptionDTO>> handlerConstraintViolationException(SQLIntegrityConstraintViolationException e, WebRequest webRequest) {
        String pathWebRequest = webRequest.getDescription(false);
        LOGGER.error(">>>>> [" + pathWebRequest + "] --> execute fail. <<<<<");
        LOGGER.error(">>>>> REASON generateConfirm EXECUTE FAIL: " + e.getMessage() + " <<<<<");
        LOGGER.info("==================== START CONSTRAINT VIOLATION EXCEPTION PROCESS ===================");
        LOGGER.warn(">>>>> [handlerConstraintViolationException] --> EXECUTE PROCESS");

        String path = webRequest.getDescription(false).substring(4);

        ObjectResult<ExceptionDTO> objectResult = new ObjectResult<>();

        objectResult.setTimestamp(TimeStampUtil.getInstance().getCurrentTimeStamp());
        objectResult.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        objectResult.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        objectResult.setMessage(MessageConstant.SYSTEM_ERROR);
        objectResult.setPath(path);

        LOGGER.info("ObjectResult: " + objectResult.toString());
        LOGGER.warn("[handlerConstraintViolationException] --> FINISH PROCESS <<<<<");
        LOGGER.info("[==================== END CONSTRAINT VIOLATION EXCEPTION PROCESS ===================]");
        return new ResponseEntity<ObjectResult<ExceptionDTO>>(objectResult, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
