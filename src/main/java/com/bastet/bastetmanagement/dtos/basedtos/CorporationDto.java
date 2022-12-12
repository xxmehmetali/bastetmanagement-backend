package com.bastet.bastetmanagement.dtos.basedtos;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CorporationDto {
    private UUID id;

    private String name;

    private String description;

    private String taxNumber;

    private String foundationDate;

    private List<ProjectDto> projects;
}
