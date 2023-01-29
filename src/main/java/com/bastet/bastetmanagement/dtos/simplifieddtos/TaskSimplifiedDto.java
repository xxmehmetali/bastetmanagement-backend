package com.bastet.bastetmanagement.dtos.simplifieddtos;

import com.bastet.bastetmanagement.core.enums.Priority;
import com.bastet.bastetmanagement.core.enums.TaskStatus;
import com.bastet.bastetmanagement.dtos.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskSimplifiedDto extends Dto {
    private UUID id;

    private String name;

    private String description;

    private String tags;

    private TaskStatus taskStatus;

    private Priority priority;

    private EmployeeSimplifiedDto assignedFrom;

    private EmployeeSimplifiedDto assignedTo;

    private EmployeeSimplifiedDto reviewer;

}
