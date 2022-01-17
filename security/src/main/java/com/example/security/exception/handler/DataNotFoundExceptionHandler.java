package com.example.security.exception.handler;

import com.example.security.dto.ExceptionDTO;
import com.example.security.exception.message.DataNotFoundExceptionMessage;
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
public class DataNotFoundExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(DataConflictExceptionHandler.class.getName());

    @ExceptionHandler(value = {DataNotFoundExceptionMessage.class})
    public ResponseEntity<ObjectResult<ExceptionDTO>> handlerDataNotFoundException(DataNotFoundExceptionMessage e, WebRequest webRequest) {
        String pathWebRequest = webRequest.getDescription(false);
        LOGGER.error(">>>>> [" + pathWebRequest + "] --> EXECUTE FAIL. <<<<<");
        LOGGER.info("==================== START HANDLER DATA NOT FOUND EXCEPTION PROCESS ===================]");
        LOGGER.warn(">>>>> [handlerDataNotFoundException] --> EXECUTE PROCESS");

        String path = webRequest.getDescription(false).substring(4);

        ObjectResult<ExceptionDTO> objectResult = new ObjectResult<>();

        objectResult.setTimestamp(TimeStampUtil.getInstance().getCurrentTimeStamp());
        objectResult.setStatus(HttpStatus.NOT_FOUND);
        objectResult.setStatusCode(HttpStatus.NOT_FOUND.value());
        objectResult.setMessage(e.getMessage());
        objectResult.setPath(path);

        LOGGER.info("ObjectResult: " + objectResult.toString());
        LOGGER.warn("[handlerDataNotFoundException] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END HANDLER DATA NOT FOUND EXCEPTION PROCESS ===================");
        return new ResponseEntity<ObjectResult<ExceptionDTO>>(objectResult, HttpStatus.NOT_FOUND);
    }

}
