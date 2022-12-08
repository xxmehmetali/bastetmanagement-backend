package com.bastet.bastetmanagement.facades.meeting.impl;

import com.bastet.bastetmanagement.dtos.basedtos.MeetingDto;
import com.bastet.bastetmanagement.facades.meeting.MeetingFacade;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MeetingFacadeImpl implements MeetingFacade {
    @Override
    public MeetingDto findById(UUID id) {
        return null;
    }
}
