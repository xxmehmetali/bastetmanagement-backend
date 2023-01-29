package com.bastet.bastetmanagement.facades.department.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.DepartmentSimplifiedDto;
import com.bastet.bastetmanagement.facades.department.DepartmentFacade;
import com.bastet.bastetmanagement.services.department.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component

public class DepartmentFacadeImpl implements DepartmentFacade {
    @Resource
    private DepartmentService departmentService;

    @Override
    public DepartmentDto findById(UUID id) {
        return null;
    }

    @Override
    public DepartmentSimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }

    @Override
    public Page<DepartmentDto> findAllPaged(Pageable pageable) {
        return null;
    }

    @Override
    public Page<DepartmentSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return null;
    }
}
