package com.bastet.bastetmanagement.facades.meetingplatform.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.MeetingPlatformDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingPlatformSimplifiedDto;
import com.bastet.bastetmanagement.facades.meetingplatform.MeetingPlatformFacade;
import com.bastet.bastetmanagement.mappers.MeetingPlatformMapper;
import com.bastet.bastetmanagement.services.meetingplatform.MeetingPlatformService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class MeetingPlatformFacadeImpl implements MeetingPlatformFacade {
    @Resource
    private MeetingPlatformService meetingPlatformService;

    @Resource
    private MeetingPlatformMapper meetingPlatformMapper;

    @Override
    public MeetingPlatformDto findById(UUID id) {
        return null;
    }

    @Override
    public MeetingPlatformSimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }

    @Override
    public Page<MeetingPlatformDto> findAllPaged(Pageable pageable) {
        return null;
    }

    @Override
    public Page<MeetingPlatformSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return null;
    }
}
