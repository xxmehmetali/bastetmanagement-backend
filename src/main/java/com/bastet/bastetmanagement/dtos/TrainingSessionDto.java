package com.bastet.bastetmanagement.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class TrainingSessionDto {
    private UUID id;

    private String name;

    private String description;

    private Date beginHour;

    private Date endHour;

    private EmployeeDto educator;

    private List<EmployeeDto> attendants;

    private MeetingPlatformDto platform;

}
