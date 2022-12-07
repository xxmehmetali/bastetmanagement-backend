package com.bastet.bastetmanagement.services.applicantmeeting.impl;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.daos.ApplicantMeetingDao;
import com.bastet.bastetmanagement.models.ApplicantMeeting;
import com.bastet.bastetmanagement.services.applicantmeeting.ApplicantMeetingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class ApplicantMeetingServiceImpl implements ApplicantMeetingService {

    @Resource
    private ApplicantMeetingDao applicantMeetingDao;

    public ApplicantMeeting findById(UUID id){
        ApplicantMeeting applicantMeeting = applicantMeetingDao.findById(id).orElse(null);
        return applicantMeeting;
    }

}
