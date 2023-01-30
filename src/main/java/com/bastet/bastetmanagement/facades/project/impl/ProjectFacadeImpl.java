package com.bastet.bastetmanagement.facades.project.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.basedtos.ProjectDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ProjectSimplifiedDto;
import com.bastet.bastetmanagement.facades.project.ProjectFacade;
import com.bastet.bastetmanagement.mappers.ProjectMapper;
import com.bastet.bastetmanagement.services.project.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class ProjectFacadeImpl implements ProjectFacade {
    @Resource
    private ProjectService projectService;

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public ProjectDto findById(UUID id) {
        return null;
    }

    @Override
    public ProjectSimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }

    @Override
    public Page<ProjectDto> findAllPaged(Pageable pageable) {
        Page pageImpl = projectService.findAllPaged(pageable);
        List<ProjectDto> dtos = projectMapper.projectListToProjectDtoList(pageImpl.getContent());
        return new PageImpl<>(dtos, pageable, pageImpl.getTotalPages());

    }

    @Override
    public Page<ProjectSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return null;
    }
}
