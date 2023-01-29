package com.bastet.bastetmanagement.dtos.basedtos;

import com.bastet.bastetmanagement.dtos.Dto;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto extends Dto {
    private UUID id;

    private String name;

    private String description;

//    private EmployeeDto departmentResponsible;

}
