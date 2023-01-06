package com.bastet.bastetmanagement.daos;

import com.bastet.bastetmanagement.models.Role;
import com.bastet.bastetmanagement.models.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}