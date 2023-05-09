package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.dtos.selectdtos.ProjectSelectElementDto;
import com.bastet.bastetmanagement.mappers.ProjectMapper;

import com.bastet.bastetmanagement.daos.ProjectDao;
import com.bastet.bastetmanagement.dtos.basedtos.ProjectDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ProjectSimplifiedDto;
import com.bastet.bastetmanagement.facades.project.ProjectFacade;
import com.bastet.bastetmanagement.models.Project;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.RecursiveTask;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController extends BaseController {
    @Resource
    private ProjectFacade projectFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id")UUID id){
        return wrapSuccessDataResultWithMessage(projectFacade.findById(id), "");
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage(projectFacade.findByIdSimplified(id), "");
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable){
        return wrapSuccessDataResultWithMessage(projectFacade.findAllPaged(pageable), "");
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable){
        return wrapSuccessDataResultWithMessage(projectFacade.findAllPagedSimplified(pageable), "");
    }
    @GetMapping("/findProjectsByCorporationId/{id}")
    public Result findProjectsByCorporationId(@PathVariable("id")UUID id){
        return wrapSuccessDataResultWithMessage(projectFacade.findProjectsByCorporationId(id), "");
    }

    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<ProjectSelectElementDto> projectSelectElementDtos = (List<ProjectSelectElementDto>) projectFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(projectSelectElementDtos, "");
    }
}
