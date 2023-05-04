package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.TaskDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.TaskSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Task;
import org.mapstruct.Mapper;

import java.util.List;

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
    //list versions
    List<Task> taskDtoListToTaskList(List<TaskDto> taskDtos);
    List<TaskDto> taskListToTaskDtoList(List<Task> tasks);

}