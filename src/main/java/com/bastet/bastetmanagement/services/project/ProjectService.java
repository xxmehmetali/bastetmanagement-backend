package com.bastet.bastetmanagement.services.project;

import com.bastet.bastetmanagement.models.Project;

import java.util.UUID;

public interface ProjectService {
    Project findById(UUID id);
}
