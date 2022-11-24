package com.bastet.bastetmanagement.daos;

import com.bastet.bastetmanagement.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BranchDao extends JpaRepository<Branch, UUID> {
}
