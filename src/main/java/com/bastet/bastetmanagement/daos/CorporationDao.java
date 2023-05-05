package com.bastet.bastetmanagement.daos;

import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CorporationDao extends JpaRepository<Corporation, UUID> {
}
