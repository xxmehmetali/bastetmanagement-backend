package com.bastet.bastetmanagement.core.customexceptions;

public class UnauthorizedAccessException extends RuntimeException {
    public UnauthorizedAccessException(){super();}
    public UnauthorizedAccessException(String message) {
        super(message);
    }
}
