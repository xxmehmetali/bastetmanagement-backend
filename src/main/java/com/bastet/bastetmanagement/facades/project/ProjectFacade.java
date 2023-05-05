package com.bastet.bastetmanagement.facades.project;

import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.ProjectDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ProjectSimplifiedDto;
import com.bastet.bastetmanagement.facades.GenericFacade;
import com.bastet.bastetmanagement.models.Project;

import java.util.List;
import java.util.UUID;

public interface ProjectFacade extends GenericFacade<Dto> {
    List<ProjectDto> findProjectsByCorporationId(UUID id);

}
