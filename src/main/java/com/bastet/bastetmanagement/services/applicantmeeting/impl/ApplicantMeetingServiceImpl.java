package com.bastet.bastetmanagement.services.applicantmeeting.impl;


import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.daos.ApplicantMeetingDao;
import com.bastet.bastetmanagement.models.ApplicantMeeting;
import com.bastet.bastetmanagement.services.applicantmeeting.ApplicantMeetingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class ApplicantMeetingServiceImpl implements ApplicantMeetingService {

    @Resource
    private ApplicantMeetingDao applicantMeetingDao;
    @Override
    public ApplicantMeeting findById(UUID id){
        return applicantMeetingDao.findById(id).orElseThrow(() -> new ModelNotFoundException("ApplicantMeeting not found."));
    }

    @Override
    public Page<ApplicantMeeting> findAllPaged(Pageable pageable) {
        return applicantMeetingDao.findAll(pageable);
    }

    @Override
    public List<ApplicantMeeting> findAll() {
        return applicantMeetingDao.findAll();
    }
}
