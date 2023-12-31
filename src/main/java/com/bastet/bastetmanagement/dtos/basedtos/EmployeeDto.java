package com.bastet.bastetmanagement.dtos.basedtos;

import com.bastet.bastetmanagement.core.enums.Gender;
import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.models.Currency;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto extends Dto {
    private UUID id;

    private String name;

    private String surname;

    private String address;

    private String phoneNumber;

    private String nationalId;

    private Gender gender;

    private OccupationDto occupation;

    private Date startDate;

    private Date endDate;

    private BranchDto branch;

    private DepartmentDto department;

    private int salaryAmount;

    private CurrencyDto salaryCurrency;

}
