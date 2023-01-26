package com.bastet.bastetmanagement.dtos.basedtos;

import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BranchDto implements Dto {

    private UUID id;

    private String name;

    private String description;

    private String phoneNumber;

    private String address;

    private CorporationDto corporation;

//    private List<EmployeeDto> employees;

    private Date createdAt;

    private Date updatedAt;
}
