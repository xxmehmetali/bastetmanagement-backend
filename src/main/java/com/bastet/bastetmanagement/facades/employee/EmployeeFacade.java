package com.bastet.bastetmanagement.facades.employee;

import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.EmployeeSimplifiedDto;

import java.util.UUID;

public interface EmployeeFacade {
    EmployeeDto findById(UUID id);
    EmployeeSimplifiedDto findByIdSimplified(UUID id);
}
