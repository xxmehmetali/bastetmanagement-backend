package com.bastet.bastetmanagement.dtos.basedtos;

import lombok.*;

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
