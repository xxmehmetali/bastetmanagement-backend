package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.daos.ProjectDao;
import com.bastet.bastetmanagement.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectDao projectDao;

    @GetMapping("/getAll")
    public List<Project> getAll(){
        System.out.println("----------------------------\nproject:");
        System.out.println(projectDao.findAll().get(0));

        System.out.println("project in corporate i");
        System.out.println(projectDao.findAll().get(0).getCorporation());
        return projectDao.findAll();
    }
}
