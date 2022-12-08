package com.bastet.bastetmanagement.facades.department.impl;

import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.facades.department.DepartmentFacade;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component

public class DepartmentFacadeImpl implements DepartmentFacade {
    @Override
    public DepartmentDto findById(UUID id) {
        return null;
    }
}
