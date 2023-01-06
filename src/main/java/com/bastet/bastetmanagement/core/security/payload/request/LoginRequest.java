package com.bastet.bastetmanagement.core.security.payload.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
}
