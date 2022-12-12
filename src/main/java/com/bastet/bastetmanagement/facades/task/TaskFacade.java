package com.bastet.bastetmanagement.facades.task;

import com.bastet.bastetmanagement.dtos.basedtos.TaskDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.TaskSimplifiedDto;

import java.util.UUID;

public interface TaskFacade {
    TaskDto findById(UUID id);
    TaskSimplifiedDto findByIdSimplified(UUID id);
}
