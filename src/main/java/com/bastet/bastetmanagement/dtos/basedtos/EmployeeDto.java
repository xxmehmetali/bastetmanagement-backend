package com.bastet.bastetmanagement.dtos.basedtos;

import com.bastet.bastetmanagement.core.enums.Gender;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
public class EmployeeDto {
    private UUID id = UUID.randomUUID();

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

}
