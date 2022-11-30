package com.bastet.bastetmanagement.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
public class DayoffDto {
    private UUID id;

    private Date beginDate;

    private Date endDate;

    private Boolean isPaid;

    private String reason;

    private EmployeeDto employee;

}
