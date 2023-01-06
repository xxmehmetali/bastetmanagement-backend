package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.mappers.TaskMapper;

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
@RequestMapping("/api/v1/task")
public class TaskController {

    @Resource
    private TaskDao taskDao;
    @Resource
    private TaskFacade taskFacade;


    @Resource
    private TaskMapper taskMapper;

    @GetMapping("/findAll")
    public List<Task> findAll(){
        return taskDao.findAll();
    }

    @GetMapping("/findById/{id}")
    public TaskDto findById(@PathVariable("id") UUID id){
//        return customModelMapper.map(taskDao.findById(id).orElse(null), TaskDto.class);
        return taskMapper.taskToTaskDto(taskDao.findById(id).orElse(null));
    }
    @GetMapping("/simplified/findById/{id}")
    public TaskSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
        return taskFacade.findByIdSimplified(id);
    }

}
