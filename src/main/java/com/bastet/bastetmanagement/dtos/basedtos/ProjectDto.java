package com.bastet.bastetmanagement.dtos.basedtos;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
public class ProjectDto {
    private UUID id;

    private String name;

    private List<ContextDto> contexts;

}
