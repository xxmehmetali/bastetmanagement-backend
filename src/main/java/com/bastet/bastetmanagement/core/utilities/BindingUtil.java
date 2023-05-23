package com.bastet.bastetmanagement.core.utilities;

import com.bastet.bastetmanagement.validators.ValidationErrors;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BindingUtil {

    public static void extractErrors(BindingResult bindingResult, ValidationErrors validationErrors) {
        bindingResult.getAllErrors().forEach((error) -> {
            Map<String, String> errorMap = new HashMap<>();

            String fieldName = ((FieldError) error).getField().toString();
            String message = error.getDefaultMessage();

            errorMap.put("field", fieldName);
            errorMap.put("errorMessage", message);
            validationErrors.getErrors().add(errorMap);
        });
    }
}
