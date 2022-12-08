package com.bastet.bastetmanagement.services.project.impl;

import com.bastet.bastetmanagement.daos.ProjectDao;
import com.bastet.bastetmanagement.models.Project;
import com.bastet.bastetmanagement.services.project.ProjectService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Log4j2
@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectDao projectDao;
    @Override
    public Project findById(UUID id) {
        Project project=projectDao.findById(id).orElse(null);

        return project;
    }
}
