package com.example.security.exception.handler;

import com.example.security.constant.MessageConstant;
import com.example.security.dto.ExceptionDTO;
import com.example.security.payload.ObjectResult;
import com.example.security.utils.TimeStampUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ConvertJsonExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(ConvertJsonExceptionHandler.class.getName());

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity<ObjectResult<ExceptionDTO>> handlerConvertJsonException(HttpMessageNotReadableException e, WebRequest webRequest) {
        String pathWebRequest = webRequest.getDescription(false);
        LOGGER.error(">>>>> [" + pathWebRequest + "] --> EXECUTE FAIL. <<<<<");
        LOGGER.error(">>>>> REASON EXECUTE FAIL: " + e.getMessage() + " <<<<<");
        LOGGER.info("==================== START HANDLER CONVERT JSON EXCEPTION PROCESS ===================");
        LOGGER.warn(">>>>> [handlerConvertJsonException] --> EXECUTE PROCESS");

        String path = webRequest.getDescription(false).substring(4);

        ObjectResult<ExceptionDTO> objectResult = new ObjectResult<>();

        objectResult.setTimestamp(TimeStampUtil.getInstance().getCurrentTimeStamp());
        objectResult.setStatus(HttpStatus.BAD_REQUEST);
        objectResult.setStatusCode(HttpStatus.BAD_REQUEST.value());
        objectResult.setMessage(MessageConstant.SYSTEM_ERROR);
        objectResult.setPath(path);

        LOGGER.info("ObjectResult: " + objectResult.toString());
        LOGGER.warn("[handlerConvertJsonException] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END HANDLER CONVERT JSON EXCEPTION PROCESS ===================");
        return new ResponseEntity<ObjectResult<ExceptionDTO>>(objectResult, HttpStatus.BAD_REQUEST);
    }

}
