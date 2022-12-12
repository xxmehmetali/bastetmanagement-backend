package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.TaskDto;
import com.bastet.bastetmanagement.models.Task;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper {
    TaskDto taskToTaskDto(Task task);
    Task taskDtoToTask(TaskDto taskDto);
}