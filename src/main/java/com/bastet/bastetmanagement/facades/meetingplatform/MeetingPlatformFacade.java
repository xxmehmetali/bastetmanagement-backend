package com.bastet.bastetmanagement.facades.meetingplatform;

import com.bastet.bastetmanagement.dtos.basedtos.MeetingPlatformDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingPlatformSimplifiedDto;

import java.util.UUID;

public interface MeetingPlatformFacade {
    MeetingPlatformDto findById(UUID id);
    MeetingPlatformSimplifiedDto findByIdSimplified(UUID id);
}
