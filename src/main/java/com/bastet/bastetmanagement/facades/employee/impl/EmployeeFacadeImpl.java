package com.bastet.bastetmanagement.facades.employee.impl;


import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.EmployeeSimplifiedDto;
import com.bastet.bastetmanagement.facades.employee.EmployeeFacade;
import com.bastet.bastetmanagement.services.employee.EmployeeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class EmployeeFacadeImpl implements EmployeeFacade {
    @Resource
    private EmployeeService employeeService;
    @Override
    public EmployeeDto findById(UUID id) {
        return null;
    }

    @Override
    public EmployeeSimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }
}
