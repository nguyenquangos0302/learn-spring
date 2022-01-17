package com.example.security.exception.handler;

import com.example.security.constant.MessageConstant;
import com.example.security.dto.ExceptionDTO;
import com.example.security.payload.ObjectResult;
import com.example.security.utils.TimeStampUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidateExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(ValidateExceptionHandler.class.getName());

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ObjectResult<ExceptionDTO>> handlerValidateException(MethodArgumentNotValidException e, WebRequest webRequest) {
        String pathWebRequest = webRequest.getDescription(false);
        LOGGER.error(">>>>> [" + pathWebRequest + "] --> execute fail. <<<<<");
        LOGGER.error(">>>>> REASON generateConfirm EXECUTE FAIL: " + e.getMessage() + " <<<<<");
        LOGGER.info("==================== START HANDLER VALIDATE EXCEPTION PROCESS ===================");
        LOGGER.warn(">>>>> [handlerValidateException] --> EXECUTE PROCESS");

        Map<String, String> fieldErrors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            fieldErrors.put(fieldName, errorMessage);
        });

        String path = webRequest.getDescription(false).substring(4);

        ExceptionDTO exceptionDTO = ExceptionDTO
                .builder()
                .errors(fieldErrors)
                .build();

        ObjectResult<ExceptionDTO> objectResult = new ObjectResult<>();

        objectResult.setTimestamp(TimeStampUtil.getInstance().getCurrentTimeStamp());
        objectResult.setStatus(HttpStatus.BAD_REQUEST);
        objectResult.setStatusCode(HttpStatus.BAD_REQUEST.value());
        objectResult.setMessage(MessageConstant.VALIDATE_ERROR);
        objectResult.setObject(exceptionDTO);
        objectResult.setPath(path);

        LOGGER.info("ObjectResult: " + objectResult.toString());
        LOGGER.warn("[handlerValidateException] --> FINISH PROCESS <<<<<");
        LOGGER.info("[==================== END HANDLER VALIDATE EXCEPTION PROCESS ===================]");
        return new ResponseEntity<ObjectResult<ExceptionDTO>>(objectResult, HttpStatus.BAD_REQUEST);
    }

}
