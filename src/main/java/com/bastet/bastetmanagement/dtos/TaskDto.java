package com.bastet.bastetmanagement.dtos;

import com.bastet.bastetmanagement.core.enums.Priority;
import com.bastet.bastetmanagement.core.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
public class TaskDto {
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
