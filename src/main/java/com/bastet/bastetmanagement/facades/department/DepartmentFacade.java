package com.bastet.bastetmanagement.facades.department;

import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.DepartmentSimplifiedDto;

import java.util.UUID;

public interface DepartmentFacade {
    DepartmentDto findById(UUID id);
    DepartmentSimplifiedDto findByIdSimplified(UUID id);
}
