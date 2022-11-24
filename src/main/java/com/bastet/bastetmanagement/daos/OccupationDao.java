package com.bastet.bastetmanagement.daos;

import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.Currency;
import com.bastet.bastetmanagement.models.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OccupationDao extends JpaRepository<Corporation, UUID> {

}
