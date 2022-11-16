package com.bastet.bastetmanagement.daos;

import com.bastet.bastetmanagement.models.Corporation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CorporationDao extends JpaRepository<Corporation, UUID> {
}
