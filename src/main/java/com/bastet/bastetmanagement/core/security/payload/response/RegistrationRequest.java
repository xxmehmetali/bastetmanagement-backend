package com.bastet.bastetmanagement.core.security.payload.response;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String username;
    private String email;
    private String password;
}
