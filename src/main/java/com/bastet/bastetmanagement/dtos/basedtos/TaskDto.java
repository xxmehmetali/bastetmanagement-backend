package com.bastet.bastetmanagement.dtos.basedtos;

import com.bastet.bastetmanagement.core.enums.Priority;
import com.bastet.bastetmanagement.core.enums.TaskStatus;
import com.bastet.bastetmanagement.dtos.Dto;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto implements Dto {
    private UUID id;

    private String name;

    private String description;

    private String tags;

    private TaskStatus taskStatus;

    private Priority priority;

    private EmployeeDto assignedFrom;

    private EmployeeDto assignedTo;

    private EmployeeDto reviewer;

    private ContextDto context;

}
