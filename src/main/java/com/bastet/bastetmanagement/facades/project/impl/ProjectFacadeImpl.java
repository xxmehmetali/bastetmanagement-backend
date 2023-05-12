package com.bastet.bastetmanagement.facades.project.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.basedtos.ProjectDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ProjectSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ProjectSimplifiedDto;
import com.bastet.bastetmanagement.facades.project.ProjectFacade;
import com.bastet.bastetmanagement.mappers.ProjectMapper;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Project;
import com.bastet.bastetmanagement.models.Project;
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
        return projectMapper.projectToProjectDto(projectService.findById(id));
    }

    @Override
    public ProjectSimplifiedDto findByIdSimplified(UUID id) {
        return projectMapper.projectToProjectSimplifiedDto(projectService.findById(id));
    }

    @Override
    public Page<ProjectDto> findAllPaged(Pageable pageable) {
        return projectService.findAllPaged(pageable).map(project -> projectMapper.projectToProjectDto(project));
    }

    @Override
    public Page<ProjectSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return projectService.findAllPaged(pageable).map(project -> projectMapper.projectToProjectSimplifiedDto(project));
    }

    @Override
    public List<ProjectDto> findProjectsByCorporationId(UUID id) {
        return projectMapper.projectListToProjectDtoList(projectService.findProjectsByCorporationId(id));
    }

    @Override
    public List<ProjectSelectElementDto> findAllForSelectElement(){
        List<Project> projects = projectService.findAll();
        return projectMapper.projectListToProjectSelectElementDtoList(projects);
    }

    @Override
    public boolean add(Dto dto) {
        Project project = projectMapper.projectDtoToProject((ProjectDto) dto);
        boolean success = projectService.add(project);
        return success;
    }
}
