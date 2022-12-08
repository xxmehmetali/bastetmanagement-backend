package com.bastet.bastetmanagement.services.department;

import com.bastet.bastetmanagement.models.Department;

import java.util.UUID;

public interface DepartmentService {
    Department findById(UUID id);
}
