package com.bastet.bastetmanagement.core.security.payload.response;

import lombok.Data;

import java.util.UUID;

@Data
public class JwtResponse {
    private String jwt;
    private UUID id;
    private String username;
    private String email;
    //x
    private String employeeId;

    public JwtResponse(String jwt, UUID id, String username, String email,
                       String employeeId
    ) {
        this.jwt = jwt;
        this.id = id;
        this.username = username;
        this.email = email;
        this.employeeId = employeeId;
    }
}
