package com.bastet.bastetmanagement.facades.employee;

import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;

import java.util.UUID;

public interface EmployeeFacade {
    EmployeeDto findById(UUID id);
}
