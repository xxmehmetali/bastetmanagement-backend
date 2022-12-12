package com.bastet.bastetmanagement.dtos.simplifieddtos;

import com.bastet.bastetmanagement.models.Corporation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectSimplifiedDto {
    private UUID id;

    private String name;

}
