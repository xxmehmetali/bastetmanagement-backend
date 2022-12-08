package com.bastet.bastetmanagement.facades.project.impl;

import com.bastet.bastetmanagement.dtos.basedtos.ProjectDto;
import com.bastet.bastetmanagement.facades.project.ProjectFacade;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProjectFacadeImpl implements ProjectFacade {
    @Override
    public ProjectDto findById(UUID id) {
        return null;
    }
}
