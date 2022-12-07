package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.daos.TaskDao;
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

    @GetMapping("/findAll")
    public List<Task> findAll(){
        return taskDao.findAll();
    }

    @GetMapping("/findById/{id}")
    public Task findById(@PathVariable("id") UUID id){
        return taskDao.findById(id).orElse(null);
    }
}
