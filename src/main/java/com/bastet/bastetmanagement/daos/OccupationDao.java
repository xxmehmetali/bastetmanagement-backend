package com.bastet.bastetmanagement.daos;

import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.Currency;
import com.bastet.bastetmanagement.models.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OccupationDao extends JpaRepository<Corporation, UUID> {

}
