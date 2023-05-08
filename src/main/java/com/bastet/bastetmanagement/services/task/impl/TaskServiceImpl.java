package com.bastet.bastetmanagement.services.task.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.daos.TaskDao;
import com.bastet.bastetmanagement.models.Task;
import com.bastet.bastetmanagement.services.task.TaskService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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

    @Override
    public Page<Task> findAllPaged(Pageable pageable) {
        return taskDao.findAll(pageable);
    }

    @Override
    public List<Task> findAll() {
        return null;
    }
}
