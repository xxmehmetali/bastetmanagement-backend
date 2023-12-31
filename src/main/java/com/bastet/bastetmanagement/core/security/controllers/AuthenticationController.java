package com.bastet.bastetmanagement.core.security.controllers;

import com.bastet.bastetmanagement.core.constants.ResultConstants;
import com.bastet.bastetmanagement.core.security.payload.request.LoginRequest;
import com.bastet.bastetmanagement.core.security.payload.response.JwtResponse;
import com.bastet.bastetmanagement.core.security.payload.response.MessageResponse;
import com.bastet.bastetmanagement.core.security.payload.response.RegistrationRequest;
import com.bastet.bastetmanagement.core.security.services.AuthenticationService;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.core.utilities.results.dataresults.DataResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    /**
     * Login a user
     * @param loginRequest the login request
     * @return the jwt response
     */
    @PostMapping("/login")
    public ResponseEntity<DataResult<JwtResponse>> authenticateUser(@RequestBody LoginRequest loginRequest) {
        log.info("Incoming password login request.");
        JwtResponse jwtResponse = authenticationService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
        DataResult<JwtResponse> jwtResponseDataResult = new DataResult<JwtResponse>(jwtResponse, true, ResultConstants.loggedInMessage());
        log.info("Successfully authenticated.");
        return ResponseEntity.ok(jwtResponseDataResult);
    }

    /**
     * Register a user
     * @param request the registration request
     * @return the response entity
     */
    @PostMapping("/register")
    public ResponseEntity<Result> registerUser(@RequestBody RegistrationRequest request) {
        log.info("Incoming registration request.");
        MessageResponse response = authenticationService.registerUser(request.getUsername(), request.getPassword(), request.getEmail());

        if (response == null) {
            log.error(" Username already exists");
            return ResponseEntity
                    .badRequest()
                    .body(
                            new Result(false, ResultConstants.USERNAME_ALREADY_EXISTS)
//                            new MessageResponse("Error: Username already exists")
                    );
        }
        log.info("User registration success.");
        return ResponseEntity.ok(new Result(true, response.getMessage()));
    }
}
