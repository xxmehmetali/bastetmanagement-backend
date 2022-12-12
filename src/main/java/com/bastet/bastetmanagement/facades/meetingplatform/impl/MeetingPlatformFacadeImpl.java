package com.bastet.bastetmanagement.facades.meetingplatform.impl;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.dtos.basedtos.MeetingPlatformDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingPlatformSimplifiedDto;
import com.bastet.bastetmanagement.facades.meetingplatform.MeetingPlatformFacade;
import com.bastet.bastetmanagement.services.meetingplatform.MeetingPlatformService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class MeetingPlatformFacadeImpl implements MeetingPlatformFacade {
    @Resource
    private MeetingPlatformService meetingPlatformService;
    @Resource
    private CustomModelMapper customModelMapper;
    @Override
    public MeetingPlatformDto findById(UUID id) {
        return null;
    }

    @Override
    public MeetingPlatformSimplifiedDto findByIdSimplified(UUID id) {
        return customModelMapper.map(meetingPlatformService.findById(id), MeetingPlatformSimplifiedDto.class);
    }
}
