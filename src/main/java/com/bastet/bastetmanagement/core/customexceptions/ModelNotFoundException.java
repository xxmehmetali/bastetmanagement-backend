package com.bastet.bastetmanagement.core.customexceptions;

import java.util.List;

public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(){super();}
    public ModelNotFoundException(String message) {
        super(message);
    }
}