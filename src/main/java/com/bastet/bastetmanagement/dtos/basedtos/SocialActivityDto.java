package com.bastet.bastetmanagement.dtos.basedtos;

import com.bastet.bastetmanagement.dtos.Dto;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialActivityDto extends Dto {
    private UUID id;

    private String name;

    private String description;

    private Date date;

    private String place;

    private List<EmployeeDto> employees;

    private ExpenseDto expense;

    private SocialActivityTypeDto socialActivityType;
}
