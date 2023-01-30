package com.bastet.bastetmanagement.facades.applicantmeeting.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantMeetingDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ApplicantMeetingSimplifiedDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ApplicantSimplifiedDto;
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
        return null;
    }

    @Override
    public ApplicantMeetingSimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }

    @Override
    public Page<ApplicantMeetingDto> findAllPaged(Pageable pageable) {
        Page pageImpl = applicantMeetingService.findAllPaged(pageable);
        List<ApplicantMeetingDto> applicantDtoss = applicantMeetingMapper.applicantMeetingListToApplicantMeetingDtoList(pageImpl.getContent());
        return new PageImpl<>(applicantDtoss, pageable, pageImpl.getTotalPages());
   }

    @Override
    public Page<? extends Dto> findAllPagedSimplified(Pageable pageable) {
        return null;
    }
}
