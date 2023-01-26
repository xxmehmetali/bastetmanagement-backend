package com.bastet.bastetmanagement.facades.department;

import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.DepartmentSimplifiedDto;
import com.bastet.bastetmanagement.facades.GenericFacade;

import java.util.UUID;

public interface DepartmentFacade extends GenericFacade<Dto> {
    DepartmentDto findById(UUID id);
    DepartmentSimplifiedDto findByIdSimplified(UUID id);
}
