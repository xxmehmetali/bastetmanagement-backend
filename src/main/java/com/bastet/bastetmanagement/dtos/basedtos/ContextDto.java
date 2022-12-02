package com.bastet.bastetmanagement.dtos.basedtos;

import lombok.*;

import java.util.UUID;

@Data
public class ContextDto {
    private UUID id;

    private String name;

    private String description;

    private ProjectDto project;

}

