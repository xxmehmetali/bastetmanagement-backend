package com.bastet.bastetmanagement.facades.meetingplatform;

import com.bastet.bastetmanagement.dtos.basedtos.MeetingPlatformDto;

import java.util.UUID;

public interface MeetingPlatformFacade {
    MeetingPlatformDto findById(UUID id);
}
