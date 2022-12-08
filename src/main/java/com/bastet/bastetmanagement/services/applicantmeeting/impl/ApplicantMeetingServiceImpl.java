package com.bastet.bastetmanagement.services.applicantmeeting.impl;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.daos.ApplicantMeetingDao;
import com.bastet.bastetmanagement.models.ApplicantMeeting;
import com.bastet.bastetmanagement.services.applicantmeeting.ApplicantMeetingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Log4j2
public class ApplicantMeetingServiceImpl implements ApplicantMeetingService {

    @Resource
    private ApplicantMeetingDao applicantMeetingDao;
    @Override
    public ApplicantMeeting findById(UUID id){
        ApplicantMeeting applicantMeeting = applicantMeetingDao.findById(id).orElse(null);
        return applicantMeeting;
    }

}
