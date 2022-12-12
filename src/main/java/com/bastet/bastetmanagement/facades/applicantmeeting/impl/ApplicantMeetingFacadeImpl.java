package com.bastet.bastetmanagement.facades.applicantmeeting.impl;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantMeetingDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ApplicantMeetingSimplifiedDto;
import com.bastet.bastetmanagement.facades.applicantmeeting.ApplicantMeetingFacade;
import com.bastet.bastetmanagement.services.applicantmeeting.ApplicantMeetingService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class ApplicantMeetingFacadeImpl implements ApplicantMeetingFacade {

    @Resource
    private CustomModelMapper customModelMapper;

    @Override
    public ApplicantMeetingDto findById(UUID id) {
        return null;
    }

    @Resource
    private ApplicantMeetingService applicantMeetingService;


    @Override
    public ApplicantMeetingSimplifiedDto findByIdSimplified(UUID id) {
        return customModelMapper.map(applicantMeetingService.findById(id), ApplicantMeetingSimplifiedDto.class);
    }

}
