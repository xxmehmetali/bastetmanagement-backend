package com.bastet.bastetmanagement.facades.task.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.basedtos.TaskDto;
import com.bastet.bastetmanagement.dtos.selectdtos.TaskSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.TaskSimplifiedDto;
import com.bastet.bastetmanagement.facades.task.TaskFacade;
import com.bastet.bastetmanagement.mappers.TaskMapper;
import com.bastet.bastetmanagement.models.Task;
import com.bastet.bastetmanagement.services.task.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class TaskFacadeImpl implements TaskFacade {
    @Resource
    private TaskService taskService;

    @Resource
    private TaskMapper taskMapper;

    @Override
    public TaskDto findById(UUID id) {
        return taskMapper.taskToTaskDto(taskService.findById(id));
    }

    @Override
    public TaskSimplifiedDto findByIdSimplified(UUID id) {
        return taskMapper.taskToTaskSimplifiedDto(taskService.findById(id));
    }

    @Override
    public Page<TaskDto> findAllPaged(Pageable pageable) {
        return taskService.findAllPaged(pageable).map(task -> taskMapper.taskToTaskDto(task));
    }

    @Override
    public Page<TaskSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return taskService.findAllPaged(pageable).map(task -> taskMapper.taskToTaskSimplifiedDto(task));
    }

    @Override
    public List<TaskSelectElementDto> findAllForSelectElement(){
        List<Task> tasks = taskService.findAll();
        return taskMapper.taskListToTaskSelectElementDtoList(tasks);
    }

    @Override
    public boolean add(Dto dto) {
        Task task = taskMapper.taskDtoToTask((TaskDto) dto);
        boolean success = taskService.add(task);
        return success;
    }
}
