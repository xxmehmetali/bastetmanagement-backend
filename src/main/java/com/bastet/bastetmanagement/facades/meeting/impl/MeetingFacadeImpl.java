package com.bastet.bastetmanagement.facades.meeting.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.basedtos.MeetingDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingSimplifiedDto;
import com.bastet.bastetmanagement.facades.meeting.MeetingFacade;
import com.bastet.bastetmanagement.mappers.MeetingMapper;
import com.bastet.bastetmanagement.models.Meeting;
import com.bastet.bastetmanagement.services.meeting.MeetingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class MeetingFacadeImpl implements MeetingFacade {
    @Resource
    private MeetingService meetingService;

    @Resource
    private MeetingMapper meetingMapper;

    @Override
    public MeetingDto findById(UUID id) {
        return meetingMapper.meetingToMeetingDto(meetingService.findById(id));
    }

    @Override
    public MeetingSimplifiedDto findByIdSimplified(UUID id) {
        return meetingMapper.meetingToMeetingSimplifiedDto(meetingService.findById(id));
    }

    @Override
    public Page<MeetingDto> findAllPaged(Pageable pageable) {
        return meetingService.findAllPaged(pageable).map(meeting -> meetingMapper.meetingToMeetingDto(meeting));
    }

    @Override
    public Page<MeetingSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return meetingService.findAllPaged(pageable).map(meeting -> meetingMapper.meetingToMeetingSimplifiedDto(meeting));
    }

    @Override
    public List<? extends Dto> findAllForSelectElement() {
        return null;
    }

    @Override
    public boolean add(Dto dto) {
        Meeting meeting = meetingMapper.meetingDtoToMeeting((MeetingDto) dto);
        boolean success = meetingService.add(meeting);
        return success;
    }
    @Override
    public boolean deleteById(UUID id) {
        return meetingService.deleteById(id);
    }
}
