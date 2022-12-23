package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ProjectDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ProjectSimplifiedDto;
import com.bastet.bastetmanagement.models.Project;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {
                ContextMapper.class,
                CorporationMapper.class
        }
)
public interface ProjectMapper {
    ProjectDto projectToProjectDto(Project project);
    Project projectDtoToProject(ProjectDto projectDto);
    ProjectSimplifiedDto projectToProjectSimplifiedDto(Project project);
    Project projectSimplifiedDtoToProject(ProjectSimplifiedDto projectSimplifiedDto);
}
