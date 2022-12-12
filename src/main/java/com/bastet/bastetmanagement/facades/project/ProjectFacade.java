package com.bastet.bastetmanagement.facades.project;

import com.bastet.bastetmanagement.dtos.basedtos.ProjectDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ProjectSimplifiedDto;

import java.util.UUID;

public interface ProjectFacade {
    ProjectDto findById(UUID id);
    ProjectSimplifiedDto findByIdSimplified(UUID id);
}
