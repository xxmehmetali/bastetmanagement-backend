package com.bastet.bastetmanagement.services.meeting;

import com.bastet.bastetmanagement.models.Meeting;

import java.util.UUID;

public interface MeetingService {
    Meeting findById(UUID id);
}
