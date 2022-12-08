package com.bastet.bastetmanagement.facades.project;

import com.bastet.bastetmanagement.dtos.basedtos.ProjectDto;

import java.util.UUID;

public interface ProjectFacade {
    ProjectDto findById(UUID id);
}
