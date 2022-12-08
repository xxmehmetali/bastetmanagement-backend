package com.bastet.bastetmanagement.facades.employee.impl;

import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.facades.employee.EmployeeFacade;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmployeeFacadeImpl implements EmployeeFacade {
    @Override
    public EmployeeDto findById(UUID id) {
        return null;
    }
}
