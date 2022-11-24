package com.bastet.bastetmanagement.daos;

import com.bastet.bastetmanagement.models.SocialActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SocialActivityDao extends JpaRepository<SocialActivity, UUID> {
}
