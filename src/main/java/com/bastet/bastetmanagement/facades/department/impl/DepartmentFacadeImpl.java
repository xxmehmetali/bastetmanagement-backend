package com.bastet.bastetmanagement.facades.department.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.CvDto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.selectdtos.DepartmentSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.DepartmentSimplifiedDto;
import com.bastet.bastetmanagement.facades.department.DepartmentFacade;
import com.bastet.bastetmanagement.mappers.DepartmentMapper;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Department;
import com.bastet.bastetmanagement.models.Department;
import com.bastet.bastetmanagement.services.department.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component

public class DepartmentFacadeImpl implements DepartmentFacade {
    @Resource
    private DepartmentService departmentService;

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public DepartmentDto findById(UUID id) {
        return departmentMapper.departmentToDepartmentDto(departmentService.findById(id));
    }

    @Override
    public DepartmentSimplifiedDto findByIdSimplified(UUID id) {
        return departmentMapper.departmentToDepartmentSimplifiedDto(departmentService.findById(id));
    }

    @Override
    public Page<DepartmentDto> findAllPaged(Pageable pageable) {
        return departmentService.findAllPaged(pageable).map(department -> departmentMapper.departmentToDepartmentDto(department));
    }

    @Override
    public Page<DepartmentSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return departmentService.findAllPaged(pageable).map(department -> departmentMapper.departmentToDepartmentSimplifiedDto(department));
    }

    @Override
    public List<DepartmentSelectElementDto> findAllForSelectElement(){
        List<Department> departments = departmentService.findAll();
        return departmentMapper.departmentListToDepartmentSelectElementDtoList(departments);
    }

    @Override
    public boolean add(Dto dto) {
        Department department = departmentMapper.departmentDtoToDepartment((DepartmentDto) dto);
        boolean success = departmentService.add(department);
        return success;
    }

    @Override
    public boolean deleteById(UUID id) {
        return departmentService.deleteById(id);
    }

    @Override
    public boolean update(Dto dto) {
        Department department = departmentMapper.departmentDtoToDepartmentForUpdate((DepartmentDto) dto);
        boolean success = departmentService.add(department);
        return success;
    }
}
