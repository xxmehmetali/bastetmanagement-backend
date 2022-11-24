package com.bastet.bastetmanagement.daos;

import com.bastet.bastetmanagement.models.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CvDao extends JpaRepository<Cv, UUID> {
}
