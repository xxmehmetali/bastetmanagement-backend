package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.daos.ProjectDao;
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

    @GetMapping("/getAll")
    public List<Project> getAll(){
        return projectDao.findAll();
    }

    @GetMapping("/findById/{id}")
    public Project findById(@PathVariable("id")UUID id){
        return projectDao.findById(id).orElse(null);
    }
}
