package com.bastet.bastetmanagement.facades.employee.impl;


import com.bastet.bastetmanagement.core.customexceptions.CustomBindingException;
import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.selectdtos.EmployeeSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.EmployeeSimplifiedDto;
import com.bastet.bastetmanagement.facades.employee.EmployeeFacade;
import com.bastet.bastetmanagement.mappers.EmployeeMapper;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Employee;
import com.bastet.bastetmanagement.models.Employee;
import com.bastet.bastetmanagement.services.employee.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.Validator;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class EmployeeFacadeImpl implements EmployeeFacade {
    @Resource
    private EmployeeService employeeService;

    @Resource
    private EmployeeMapper employeeMapper;

    @Resource(name = "employeeValidator")
    private Validator employeeValidator;

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
        return employees.stream()
                .map(employee -> {
                    return employeeMapper.employeeToEmployeeSelectElementDto(employee);
                })
                .collect(Collectors.toList());
    }
    @Override
    public boolean add(Dto dto) {
        Employee employee = employeeMapper.employeeDtoToEmployee((EmployeeDto) dto);
        BindingResult bindingResult = new BeanPropertyBindingResult(employee, "employee");
        employeeValidator.validate(employee, bindingResult);
        if (bindingResult.hasErrors()){
            // Will be catched by GlobalExceptionHandler
            throw new CustomBindingException(bindingResult);
        }
        boolean success = employeeService.add(employee);
        return success;
    }

    @Override
    public void update(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.employeeDtoToEmployeeForUpdate(employeeDto);
        employeeService.add(employee);
    }
}
