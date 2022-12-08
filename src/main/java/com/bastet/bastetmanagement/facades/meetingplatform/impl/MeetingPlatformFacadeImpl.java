package com.bastet.bastetmanagement.facades.meetingplatform.impl;

import com.bastet.bastetmanagement.dtos.basedtos.MeetingPlatformDto;
import com.bastet.bastetmanagement.facades.meetingplatform.MeetingPlatformFacade;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MeetingPlatformFacadeImpl implements MeetingPlatformFacade {
    @Override
    public MeetingPlatformDto findById(UUID id) {
        return null;
    }
}
