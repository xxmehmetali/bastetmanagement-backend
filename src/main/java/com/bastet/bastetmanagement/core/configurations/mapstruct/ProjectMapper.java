package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.ProjectDto;
import com.bastet.bastetmanagement.models.Project;
import org.mapstruct.Mapper;

@Mapper
public interface ProjectMapper {
    ProjectDto projectToProjectDto(Project project);
    Project projectDtoToProject(ProjectDto projectDto);
}
