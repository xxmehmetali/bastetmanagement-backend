package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.ProjectDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ProjectSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ProjectSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                ContextMapper.class,
                CorporationMapper.class
        }
)
public interface ProjectMapper {
    ProjectDto projectToProjectDto(Project project);

    @Mapping(ignore = true, target = "id")
    @Mapping(source = "corporation", target = "corporation", qualifiedByName = "corporationDtoToCorporationIdStatic")
    Project projectDtoToProject(ProjectDto projectDto);

    @Named("projectDtoToProjectIdStatic")
    Project projectDtoToProjectIdStatic(ProjectDto projectDto);

    ProjectSimplifiedDto projectToProjectSimplifiedDto(Project project);
    Project projectSimplifiedDtoToProject(ProjectSimplifiedDto projectSimplifiedDto);
    //list versions
    List<Project> projectDtoListToProjectList(List<ProjectDto> projectDtos);
    List<ProjectDto> projectListToProjectDtoList(List<Project> projects);
    List<ProjectSelectElementDto> projectListToProjectSelectElementDtoList(List<Project> projects);

}
