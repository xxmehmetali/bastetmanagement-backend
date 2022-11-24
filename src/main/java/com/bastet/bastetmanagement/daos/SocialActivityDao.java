package com.bastet.bastetmanagement.daos;

import com.bastet.bastetmanagement.models.SocialActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SocialActivityDao extends JpaRepository<SocialActivity, UUID> {
}
