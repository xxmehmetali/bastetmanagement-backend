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
    Project projectDtoToProject(ProjectDto projectDto);
    ProjectSimplifiedDto projectToProjectSimplifiedDto(Project project);
    Project projectSimplifiedDtoToProject(ProjectSimplifiedDto projectSimplifiedDto);
    //list versions
    List<Project> projectDtoListToProjectList(List<ProjectDto> projectDtos);
    List<ProjectDto> projectListToProjectDtoList(List<Project> projects);
    List<ProjectSelectElementDto> projectListToProjectSelectElementDtoList(List<Project> projects);

}
