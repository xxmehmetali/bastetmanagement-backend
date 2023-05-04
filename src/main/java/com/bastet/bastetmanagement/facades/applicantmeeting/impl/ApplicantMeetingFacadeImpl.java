package com.bastet.bastetmanagement.facades.applicantmeeting.impl;


import com.bastet.bastetmanagement.dtos.basedtos.ApplicantMeetingDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ApplicantMeetingSimplifiedDto;
import com.bastet.bastetmanagement.facades.applicantmeeting.ApplicantMeetingFacade;
import com.bastet.bastetmanagement.mappers.ApplicantMeetingMapper;
import com.bastet.bastetmanagement.models.ApplicantMeeting;
import com.bastet.bastetmanagement.services.applicantmeeting.ApplicantMeetingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class ApplicantMeetingFacadeImpl implements ApplicantMeetingFacade {
    @Resource
    private ApplicantMeetingService applicantMeetingService;

    @Resource
    private ApplicantMeetingMapper applicantMeetingMapper;

    @Override
    public ApplicantMeetingDto findById(UUID id) {
        return applicantMeetingMapper.applicantMeetingToApplicantMeetingDto(applicantMeetingService.findById(id));
    }

    @Override
    public ApplicantMeetingSimplifiedDto findByIdSimplified(UUID id) {
        return applicantMeetingMapper.applicantMeetingToApplicantMeetingSimplifiedDto(applicantMeetingService.findById(id));
    }

    @Override
    public Page<ApplicantMeetingDto> findAllPaged(Pageable pageable) {
        return applicantMeetingService.findAllPaged(pageable).map(applicantMeeting -> applicantMeetingMapper.applicantMeetingToApplicantMeetingDto(applicantMeeting));
   }

    @Override
    public Page<ApplicantMeetingSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return applicantMeetingService.findAllPaged(pageable).map(applicantMeeting -> applicantMeetingMapper.applicantMeetingToApplicantMeetingSimplifiedDto(applicantMeeting));
    }
}
