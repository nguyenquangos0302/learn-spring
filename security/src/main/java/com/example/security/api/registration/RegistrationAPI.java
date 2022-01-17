package com.example.security.api.registration;

import com.example.security.constant.MessageConstant;
import com.example.security.constant.PathConstant;
import com.example.security.payload.ObjectResult;
import com.example.security.payload.request.RegisterRequest;
import com.example.security.payload.response.RegisterResponse;
import com.example.security.service.IUserService;
import com.example.security.utils.TimeStampUtil;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/registration")
@AllArgsConstructor
public class RegistrationAPI {

    private static final Logger LOGGER = LogManager.getLogger(RegistrationAPI.class.getName());

    private IUserService userService;

    @PostMapping()
    public ResponseEntity<ObjectResult<RegisterResponse>> register(@Valid @RequestBody RegisterRequest registerRequest) {
        LOGGER.info("==================== START REGISTRATION API PROCESS ===================");
        LOGGER.warn(">>>>> [register] --> EXECUTE PROCESS");
        LOGGER.info("REQUEST: " + new Gson().toJson(registerRequest));
        RegisterResponse registration = userService.save(registerRequest);
        ObjectResult<RegisterResponse> responseObjectResult = new ObjectResult<>();
        responseObjectResult.setTimestamp(TimeStampUtil.getInstance().getCurrentTimeStamp());
        responseObjectResult.setStatus(HttpStatus.CREATED);
        responseObjectResult.setStatusCode(HttpStatus.CREATED.value());
        responseObjectResult.setMessage(MessageConstant.USER_CREATE_SUCCESS);
        responseObjectResult.setObject(registration);
        responseObjectResult.setPath(PathConstant.PATH_CREATE_USER);
        LOGGER.warn("RESPONSE: " + responseObjectResult.toString());
        LOGGER.warn("[register] --> FINISH PROCESS <<<<<");
        LOGGER.info("==================== END REGISTRATION API PROCESS ===================");
        return new ResponseEntity<ObjectResult<RegisterResponse>>(responseObjectResult, HttpStatus.CREATED);
    }

}
