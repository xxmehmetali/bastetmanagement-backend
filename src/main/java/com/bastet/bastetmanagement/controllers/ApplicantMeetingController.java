package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.daos.ApplicantMeetingDao;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantMeetingDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ApplicantMeetingSimplifiedDto;
import com.bastet.bastetmanagement.facades.applicantmeeting.ApplicantMeetingFacade;
import com.bastet.bastetmanagement.models.ApplicantMeeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/applicantMeeting")
public class ApplicantMeetingController {
    @Resource
    private ApplicantMeetingDao applicantMeetingDao;
    @Resource
    private CustomModelMapper customModelMapper;

    @Resource
    private ApplicantMeetingFacade applicantMeetingFacade;

    @GetMapping("/findById/{id}")
    public ApplicantMeetingDto findById(@PathVariable("id") UUID id){
        ApplicantMeeting applicantMeeting = applicantMeetingDao.findById(id).orElse(null);
        return customModelMapper.map(applicantMeeting, ApplicantMeetingDto.class);
    }

    @GetMapping("/simplified/findById/{id}")
    public ApplicantMeetingSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
        return applicantMeetingFacade.findByIdSimplified(id);
    }


}
