package com.bastet.bastetmanagement.facades.meetingplatform;

import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.MeetingPlatformDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingPlatformSimplifiedDto;
import com.bastet.bastetmanagement.facades.GenericFacade;

import java.util.UUID;

public interface MeetingPlatformFacade extends GenericFacade<Dto> {
    MeetingPlatformDto findById(UUID id);
    MeetingPlatformSimplifiedDto findByIdSimplified(UUID id);
}
