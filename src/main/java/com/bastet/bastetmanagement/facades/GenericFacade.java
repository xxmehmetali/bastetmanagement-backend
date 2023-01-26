package com.bastet.bastetmanagement.facades;

import com.bastet.bastetmanagement.dtos.basedtos.TaskDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.TaskSimplifiedDto;

import java.util.UUID;

public interface GenericFacade<T> {

    T findById(UUID id);
    T findByIdSimplified(UUID id);
}
