package com.bastet.bastetmanagement.services.task.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.daos.TaskDao;
import com.bastet.bastetmanagement.models.Task;
import com.bastet.bastetmanagement.services.task.TaskService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Log4j2
public class TaskServiceImpl implements TaskService {
    @Resource
    private TaskDao taskDao;

    @Override
    public Task findById(UUID id) {
        return taskDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Task not found"));
    }

}
