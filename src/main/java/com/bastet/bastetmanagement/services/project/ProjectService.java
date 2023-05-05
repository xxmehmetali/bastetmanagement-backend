package com.bastet.bastetmanagement.services.project;

import com.bastet.bastetmanagement.models.Project;
import com.bastet.bastetmanagement.services.GenericService;

import java.util.List;
import java.util.UUID;

public interface ProjectService extends GenericService<Project> {

     List<Project> findProjectsByCorporationId(UUID id) ;
}
