package com.bastet.bastetmanagement.dtos.basedtos;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class SocialActivityDto {
    private UUID id;

    private String name;

    private String description;

    private Date date;

    private String place;

    private List<EmployeeDto> employees;

    private SocialActivityTypeDto socialActivityType;
}
