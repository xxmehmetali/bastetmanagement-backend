package com.bastet.bastetmanagement.facades.task.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.TaskDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.TaskSimplifiedDto;
import com.bastet.bastetmanagement.facades.task.TaskFacade;
import com.bastet.bastetmanagement.mappers.TaskMapper;
import com.bastet.bastetmanagement.services.task.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class TaskFacadeImpl implements TaskFacade {
    @Resource
    private TaskService taskService;

    @Resource
    private TaskMapper taskMapper;

    @Override
    public TaskDto findById(UUID id) {
        return null;
    }

    @Override
    public TaskSimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }

    @Override
    public Page<TaskDto> findAllPaged(Pageable pageable) {
        return null;
    }

    @Override
    public Page<TaskSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return null;
    }
}
