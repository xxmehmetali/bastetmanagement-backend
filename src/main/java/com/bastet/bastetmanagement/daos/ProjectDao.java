package com.bastet.bastetmanagement.daos;

import com.bastet.bastetmanagement.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectDao extends JpaRepository<Project, UUID> {

}
