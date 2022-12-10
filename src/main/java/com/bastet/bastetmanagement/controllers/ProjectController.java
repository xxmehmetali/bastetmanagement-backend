package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.daos.ProjectDao;
import com.bastet.bastetmanagement.dtos.basedtos.ProjectDto;
import com.bastet.bastetmanagement.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Resource
    private ProjectDao projectDao;
    @Resource
    private CustomModelMapper customModelMapper;
    @GetMapping("/getAll")
    public List<Project> getAll(){
        return projectDao.findAll();
    }

    @GetMapping("/findById/{id}")
    public ProjectDto findById(@PathVariable("id")UUID id){
        return customModelMapper.map(projectDao.findById(id).orElse(null), ProjectDto.class);
    }
}
