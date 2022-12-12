package com.bastet.bastetmanagement.dtos.basedtos;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private UUID id;

    private String name;

    private String description;

//    private EmployeeDto departmentResponsible;

}
