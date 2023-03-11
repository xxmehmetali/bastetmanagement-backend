package com.bastet.bastetmanagement.services.meeting.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.daos.MeetingDao;
import com.bastet.bastetmanagement.models.Meeting;
import com.bastet.bastetmanagement.services.meeting.MeetingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Log4j2
public class MeetingServiceImpl implements MeetingService {
    @Resource
    private MeetingDao meetingDao;

    @Override
    public Meeting findById(UUID id) {
        return meetingDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Meeting not found."));
    }

    @Override
    public Page<Meeting> findAllPaged(Pageable pageable) {
        return meetingDao.findAll(pageable);
    }
}
