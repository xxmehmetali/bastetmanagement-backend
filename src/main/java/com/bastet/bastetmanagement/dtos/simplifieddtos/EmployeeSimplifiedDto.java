package com.bastet.bastetmanagement.dtos.simplifieddtos;

import com.bastet.bastetmanagement.core.enums.Gender;
import com.bastet.bastetmanagement.dtos.Dto;
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
public class EmployeeSimplifiedDto implements Dto {
    private UUID id;

    private String name;

    private String surname;

    private String address;

    private String phoneNumber;

    private Gender gender;

    private OccupationSimplifiedDto occupation;

    private Date startDate;

    private Date endDate;

    private BranchSimplifiedDto branch;

    private DepartmentSimplifiedDto department;

}
