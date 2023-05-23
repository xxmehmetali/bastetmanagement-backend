package com.bastet.bastetmanagement.facades.meetingplatform.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.basedtos.MeetingPlatformDto;
import com.bastet.bastetmanagement.dtos.selectdtos.MeetingPlatformSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingPlatformSimplifiedDto;
import com.bastet.bastetmanagement.facades.meetingplatform.MeetingPlatformFacade;
import com.bastet.bastetmanagement.mappers.MeetingPlatformMapper;
import com.bastet.bastetmanagement.models.MeetingPlatform;
import com.bastet.bastetmanagement.services.meetingplatform.MeetingPlatformService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MeetingPlatformFacadeImpl implements MeetingPlatformFacade {
    @Resource
    private MeetingPlatformService meetingPlatformService;

    @Resource
    private MeetingPlatformMapper meetingPlatformMapper;

    @Override
    public MeetingPlatformDto findById(UUID id) {
        return meetingPlatformMapper.meetingPlatformToMeetingPlatformDto(meetingPlatformService.findById(id));
    }

    @Override
    public MeetingPlatformSimplifiedDto findByIdSimplified(UUID id) {
        return meetingPlatformMapper.meetingPlatformToMeetingPlatformSimplifiedDto(meetingPlatformService.findById(id));
    }

    @Override
    public Page<MeetingPlatformDto> findAllPaged(Pageable pageable) {
        return meetingPlatformService.findAllPaged(pageable).map(meetingPlatform -> meetingPlatformMapper.meetingPlatformToMeetingPlatformDto(meetingPlatform));
    }

    @Override
    public Page<MeetingPlatformSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return meetingPlatformService.findAllPaged(pageable).map(meetingPlatform -> meetingPlatformMapper.meetingPlatformToMeetingPlatformSimplifiedDto(meetingPlatform));
    }

    @Override
    public boolean add(Dto dto) {
        MeetingPlatform meetingPlatform = meetingPlatformMapper.meetingPlatformDtoToMeetingPlatform((MeetingPlatformDto) dto);
        boolean success = meetingPlatformService.add(meetingPlatform);
        return success;
    }

    public List<MeetingPlatformSelectElementDto> findAllForSelectElement(){
        List<MeetingPlatform> meetingPlatforms = meetingPlatformService.findAll();
        return meetingPlatforms.stream()
                .map(meetingPlatform -> {
                    return meetingPlatformMapper.meetingToMeetingPlatformSelectElementDto(meetingPlatform);
                })
                .collect(Collectors.toList());
    }
    @Override
    public boolean deleteById(UUID id) {
        return meetingPlatformService.deleteById(id);
    }

}
