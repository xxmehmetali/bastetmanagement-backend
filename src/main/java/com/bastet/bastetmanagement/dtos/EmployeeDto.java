package com.bastet.bastetmanagement.dtos;

import com.bastet.bastetmanagement.core.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
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

    private long department;

}
