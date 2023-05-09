package com.bastet.bastetmanagement.facades.employee.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.selectdtos.EmployeeSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.EmployeeSimplifiedDto;
import com.bastet.bastetmanagement.facades.employee.EmployeeFacade;
import com.bastet.bastetmanagement.mappers.EmployeeMapper;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Employee;
import com.bastet.bastetmanagement.services.employee.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class EmployeeFacadeImpl implements EmployeeFacade {
    @Resource
    private EmployeeService employeeService;

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto findById(UUID id) {
        return employeeMapper.employeeToEmployeeDto(employeeService.findById(id));
    }

    @Override
    public EmployeeSimplifiedDto findByIdSimplified(UUID id) {
        return employeeMapper.employeeToEmployeeSimplifiedDto(employeeService.findById(id));
    }

    @Override
    public Page<EmployeeDto> findAllPaged(Pageable pageable) {
        return employeeService.findAllPaged(pageable).map(employee -> employeeMapper.employeeToEmployeeDto(employee));
    }

    @Override
    public Page<EmployeeSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return employeeService.findAllPaged(pageable).map(employee -> employeeMapper.employeeToEmployeeSimplifiedDto(employee));
    }

    @Override
    public List<EmployeeSelectElementDto> findAllForSelectElement(){
        List<Employee> employees = employeeService.findAll();
        return employeeMapper.employeeListToEmployeeSelectElementDtoList(employees);
    }}
