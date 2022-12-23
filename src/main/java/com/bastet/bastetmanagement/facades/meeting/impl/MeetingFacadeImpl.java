package com.bastet.bastetmanagement.facades.meeting.impl;


import com.bastet.bastetmanagement.dtos.basedtos.MeetingDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingSimplifiedDto;
import com.bastet.bastetmanagement.facades.meeting.MeetingFacade;
import com.bastet.bastetmanagement.services.meeting.MeetingService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class MeetingFacadeImpl implements MeetingFacade {
    @Resource
    private MeetingService meetingService;

    @Override
    public MeetingDto findById(UUID id) {
        return null;
    }

    @Override
    public MeetingSimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }
}
