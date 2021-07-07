package com.example.demo.api;

import com.example.demo.config.password.PasswordConfig;
import com.example.demo.payload.request.user.RegistrationRequest;
import com.example.demo.payload.response.ObjectResult;
import com.example.demo.payload.response.user.RegistrationResponse;
import com.example.demo.service.IUserService;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserAPI {

    private static final Logger LOGGER = Logger.getLogger(UserAPI.class.getName());

    private IUserService userService;

    @PostMapping("/registration")
    public ResponseEntity<ObjectResult<RegistrationResponse>> registrationUser(@Valid @RequestBody RegistrationRequest registrationRequest) {
        LOGGER.info("[registrationUser] --> execute");
        ObjectResult<RegistrationResponse> registrationResponse = userService.save(registrationRequest);
        return new ResponseEntity<ObjectResult<RegistrationResponse>>(registrationResponse, HttpStatus.OK);
    }

}
