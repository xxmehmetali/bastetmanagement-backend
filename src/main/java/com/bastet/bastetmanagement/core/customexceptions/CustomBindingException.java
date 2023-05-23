package com.bastet.bastetmanagement.core.customexceptions;

import org.springframework.validation.BindingResult;

public class CustomBindingException extends RuntimeException {
    private BindingResult bindingResult;
    public CustomBindingException(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }
}
