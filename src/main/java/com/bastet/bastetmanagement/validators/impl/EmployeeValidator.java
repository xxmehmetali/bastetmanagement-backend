package com.bastet.bastetmanagement.validators.impl;

import com.bastet.bastetmanagement.models.Employee;
import com.bastet.bastetmanagement.validators.BaseValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component(value = "employeeValidator")
public class EmployeeValidator implements BaseValidator, Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;

        if (employee.getName().length() < 1){
            errors.rejectValue("name", "0", "asd");
        }

    }
}
