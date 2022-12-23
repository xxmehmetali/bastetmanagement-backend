package com.bastet.bastetmanagement.facades.project.impl;


import com.bastet.bastetmanagement.dtos.basedtos.ProjectDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ProjectSimplifiedDto;
import com.bastet.bastetmanagement.facades.project.ProjectFacade;
import com.bastet.bastetmanagement.services.project.ProjectService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class ProjectFacadeImpl implements ProjectFacade {
    @Resource
    private ProjectService projectService;

    @Override
    public ProjectDto findById(UUID id) {
        return null;
    }

    @Override
    public ProjectSimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }
}
