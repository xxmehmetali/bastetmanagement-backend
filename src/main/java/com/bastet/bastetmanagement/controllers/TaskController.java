package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.mappers.TaskMapper;

import com.bastet.bastetmanagement.daos.TaskDao;
import com.bastet.bastetmanagement.dtos.basedtos.TaskDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.TaskSimplifiedDto;
import com.bastet.bastetmanagement.facades.task.TaskFacade;
import com.bastet.bastetmanagement.models.Task;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController extends BaseController {
    @Resource
    private TaskFacade taskFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage(taskFacade.findById(id), "");
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage(taskFacade.findByIdSimplified(id), "");
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable){
        return wrapSuccessDataResultWithMessage(taskFacade.findAllPaged(pageable), "");
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable){
        return wrapSuccessDataResultWithMessage(taskFacade.findAllPagedSimplified(pageable), "");
    }

}
