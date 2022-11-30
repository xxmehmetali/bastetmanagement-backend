package com.bastet.bastetmanagement.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.ArrayList;
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
