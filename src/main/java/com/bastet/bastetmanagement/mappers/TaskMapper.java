package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.TaskDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.TaskSimplifiedDto;
import com.bastet.bastetmanagement.models.Task;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {
                EmployeeMapper.class,
                ContextMapper.class
        }
)
public interface TaskMapper {
    TaskDto taskToTaskDto(Task task);
    Task taskDtoToTask(TaskDto taskDto);
    TaskSimplifiedDto taskToTaskSimplifiedDto(Task task);
    Task taskSimplifiedDtoToTask(TaskSimplifiedDto taskSimplifiedDto);
}