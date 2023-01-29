package com.bastet.bastetmanagement.facades.employee.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.EmployeeSimplifiedDto;
import com.bastet.bastetmanagement.facades.employee.EmployeeFacade;
import com.bastet.bastetmanagement.mappers.EmployeeMapper;
import com.bastet.bastetmanagement.services.employee.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class EmployeeFacadeImpl implements EmployeeFacade {
    @Resource
    private EmployeeService employeeService;

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto findById(UUID id) {
        return null;
    }

    @Override
    public EmployeeSimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }

    @Override
    public Page<EmployeeDto> findAllPaged(Pageable pageable) {
        return null;
    }

    @Override
    public Page<EmployeeSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return null;
    }
}
