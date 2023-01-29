package com.bastet.bastetmanagement.facades;

import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.TaskDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.TaskSimplifiedDto;

import java.util.UUID;

public interface GenericFacade<T> {
    Dto findById(UUID id);
    Dto findByIdSimplified(UUID id);
}
