package com.bastet.bastetmanagement.services.meetingplatform.impl;

import com.bastet.bastetmanagement.daos.MeetingPlatformDao;
import com.bastet.bastetmanagement.models.MeetingPlatform;
import com.bastet.bastetmanagement.services.meetingplatform.MeetingPlatformService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Log4j2
public class MeetingPlatformServiceImpl implements MeetingPlatformService {
    @Resource
    private MeetingPlatformDao meetingPlatformDao;
    @Override
    public MeetingPlatform findById(UUID id) {
        MeetingPlatform meetingPlatform=meetingPlatformDao.findById(id).orElse(null);

        return meetingPlatform;
    }

    @Override
    public Page<MeetingPlatform> findAllPaged(Pageable pageable) {
        return null;
    }
}
