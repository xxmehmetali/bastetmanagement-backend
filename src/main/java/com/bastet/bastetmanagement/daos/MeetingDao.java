package com.bastet.bastetmanagement.daos;

import com.bastet.bastetmanagement.models.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MeetingDao extends JpaRepository<Meeting, UUID> {
}
