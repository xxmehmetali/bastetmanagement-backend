package com.bastet.bastetmanagement.facades.task.impl;

import com.bastet.bastetmanagement.dtos.basedtos.TaskDto;
import com.bastet.bastetmanagement.facades.task.TaskFacade;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TaskFacadeImpl implements TaskFacade {
    @Override
    public TaskDto findById(UUID id) {
        return null;
    }
}
