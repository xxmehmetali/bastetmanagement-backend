package com.bastet.bastetmanagement.services.meetingplatform;

import com.bastet.bastetmanagement.models.MeetingPlatform;

import java.util.UUID;

public interface MeetingPlatformService {
    MeetingPlatform findById(UUID id);
}
