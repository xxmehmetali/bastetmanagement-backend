package com.bastet.bastetmanagement.facades.project;

import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.ProjectDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ProjectSimplifiedDto;
import com.bastet.bastetmanagement.facades.GenericFacade;

import java.util.UUID;

public interface ProjectFacade extends GenericFacade<Dto> {
    ProjectDto findById(UUID id);
    ProjectSimplifiedDto findByIdSimplified(UUID id);
}
