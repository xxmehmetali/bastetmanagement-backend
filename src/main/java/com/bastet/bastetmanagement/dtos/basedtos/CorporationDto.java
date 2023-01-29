package com.bastet.bastetmanagement.dtos.basedtos;

import com.bastet.bastetmanagement.dtos.Dto;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CorporationDto extends Dto {
    private UUID id;

    private String name;

    private String description;

    private String taxNumber;

    private String foundationDate;

    private List<ProjectDto> projects;
}
