package com.bastet.bastetmanagement.core.security.services;

import com.bastet.bastetmanagement.core.security.payload.response.JwtResponse;
import com.bastet.bastetmanagement.core.security.payload.response.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {


    /**
     * Authenticate a user
     * @param username the username
     * @param password the password
     * @return the jwt response
     */
    JwtResponse authenticateUser(String username, String password);

    /**
     * Register a user
     * @param username tha username
     * @param password the password
     * @param email the email
     * @return the success response with message
     */
    MessageResponse registerUser(String username, String password, String email);
}
