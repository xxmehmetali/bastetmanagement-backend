package com.bastet.bastetmanagement.dtos.simplifieddtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DayoffSimplifiedDto {
    private UUID id;

    private Date beginDate;

    private Date endDate;

    private Boolean isPaid;

    private String reason;

    private EmployeeSimplifiedDto employee;

}
