package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.daos.ApplicantMeetingDao;
import com.bastet.bastetmanagement.dtos.Dto;
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
@RequestMapping("/api/v1/applicantMeeting")
public class ApplicantMeetingController extends BaseController {
    @Resource
    private ApplicantMeetingFacade applicantMeetingFacade;

    @GetMapping("/findById/{id}")
    public ApplicantMeetingDto findById(@PathVariable("id") UUID id){
        ApplicantMeeting applicantMeeting = applicantMeetingDao.findById(id).orElse(null);
        return null;
    }

    @GetMapping("/simplified/findById/{id}")
    public ApplicantMeetingSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
        return (ApplicantMeetingSimplifiedDto) applicantMeetingFacade.findByIdSimplified(id);
    }


}
