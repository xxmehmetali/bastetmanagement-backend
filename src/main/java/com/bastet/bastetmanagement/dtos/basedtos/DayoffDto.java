package com.bastet.bastetmanagement.dtos.basedtos;

import com.bastet.bastetmanagement.dtos.Dto;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DayoffDto implements Dto {
    private UUID id;

    private Date beginDate;

    private Date endDate;

    private Boolean isPaid;

    private String reason;

    private EmployeeDto employee;

}
