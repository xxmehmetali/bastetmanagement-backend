package com.bastet.bastetmanagement.daos;

import com.bastet.bastetmanagement.models.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParentDao extends JpaRepository<Parent, UUID> {
    Parent findByName(String name);
}
