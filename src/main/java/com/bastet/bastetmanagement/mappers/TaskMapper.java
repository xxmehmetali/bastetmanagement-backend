package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.TaskDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.TaskSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.TaskSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                EmployeeMapper.class,
                ContextMapper.class
        }
)
public interface TaskMapper {
    @Mappings({
            @Mapping(source = "assignedFrom", target = "assignedFrom", qualifiedByName = "employeeToEmployeeDto"),
            @Mapping(source = "assignedTo", target = "assignedTo", qualifiedByName = "employeeToEmployeeDto"),
            @Mapping(source = "reviewer", target = "reviewer", qualifiedByName = "employeeToEmployeeDto")
    })
    TaskDto taskToTaskDto(Task task);

    @Mapping(ignore = true, target = "id")
    @Mappings({
            @Mapping(source = "assignedFrom", target = "assignedFrom", qualifiedByName = "employeeDtoToEmployeeOnlyId"),
            @Mapping(source = "assignedTo", target = "assignedTo", qualifiedByName = "employeeDtoToEmployeeOnlyId"),
            @Mapping(source = "reviewer", target = "reviewer", qualifiedByName = "employeeDtoToEmployeeOnlyId"),
            @Mapping(source = "context", target = "context", qualifiedByName = "contextDtoToContextOnlyId")

    })
     Task taskDtoToTask(TaskDto taskDto);

    @Mappings({
            @Mapping(source = "assignedFrom", target = "assignedFrom", qualifiedByName = "employeeDtoToEmployeeOnlyId"),
            @Mapping(source = "assignedTo", target = "assignedTo", qualifiedByName = "employeeDtoToEmployeeOnlyId"),
            @Mapping(source = "reviewer", target = "reviewer", qualifiedByName = "employeeDtoToEmployeeOnlyId"),
            @Mapping(source = "context", target = "context", qualifiedByName = "contextDtoToContextOnlyId")
    })
    @Named("taskDtoToTaskForUpdate")
    Task taskDtoToTaskForUpdate(TaskDto taskDto);

    @Named("taskDtoToTaskIdStatic")
    Task taskDtoToTaskIdStatic(TaskDto taskDto);

    TaskSimplifiedDto taskToTaskSimplifiedDto(Task task);
    Task taskSimplifiedDtoToTask(TaskSimplifiedDto taskSimplifiedDto);
    //list versions
    List<Task> taskDtoListToTaskList(List<TaskDto> taskDtos);
    List<TaskDto> taskListToTaskDtoList(List<Task> tasks);
    List<TaskSelectElementDto> taskListToTaskSelectElementDtoList(List<Task> tasks);

}