package com.bastet.bastetmanagement.services.task;

import com.bastet.bastetmanagement.models.Task;

import java.util.UUID;

public interface TaskService {
    Task findById(UUID id);
}
