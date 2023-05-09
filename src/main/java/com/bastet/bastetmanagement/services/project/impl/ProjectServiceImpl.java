package com.bastet.bastetmanagement.services.project.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.daos.ProjectDao;
import com.bastet.bastetmanagement.models.Project;
import com.bastet.bastetmanagement.services.project.ProjectService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Log4j2
@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectDao projectDao;

    @Override
    public Project findById(UUID id) {
        return projectDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Project not found."));
    }

    @Override
    public Page<Project> findAllPaged(Pageable pageable) {
        return projectDao.findAll(pageable);
    }


    @Override
    public List<Project> findProjectsByCorporationId(UUID id) {
        return projectDao.findProjectsByCorporationId(id);
    }

    @Override
    public List<Project> findAll() {
        return projectDao.findAll();
    }
}
