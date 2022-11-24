package com.bastet.bastetmanagement.daos;

import com.bastet.bastetmanagement.models.SocialActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SocialActivityTypeDao extends JpaRepository<SocialActivityType, UUID> {
}
