package com.bastet.bastetmanagement.services.employee;

import com.bastet.bastetmanagement.models.Employee;

import java.util.UUID;

public interface EmployeeService {
    Employee findById(UUID id);
}
