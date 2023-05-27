package com.bastet.bastetmanagement.daos;

import com.bastet.bastetmanagement.models.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChildDao extends JpaRepository<Child, UUID> {
    Child findByName(String name);
}
