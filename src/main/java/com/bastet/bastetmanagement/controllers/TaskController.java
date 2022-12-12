package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.daos.TaskDao;
import com.bastet.bastetmanagement.dtos.basedtos.TaskDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.TaskSimplifiedDto;
import com.bastet.bastetmanagement.facades.task.TaskFacade;
import com.bastet.bastetmanagement.models.Task;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Resource
    private TaskDao taskDao;
    @Resource
    private TaskFacade taskFacade;

    @Resource
    private CustomModelMapper customModelMapper;
    @GetMapping("/findAll")
    public List<Task> findAll(){
        return taskDao.findAll();
    }

    @GetMapping("/findById/{id}")
    public TaskDto findById(@PathVariable("id") UUID id){
        return customModelMapper.map(taskDao.findById(id).orElse(null), TaskDto.class);
    }
    @GetMapping("/simplified/findById/{id}")
    public TaskSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
        return taskFacade.findByIdSimplified(id);
    }

}
