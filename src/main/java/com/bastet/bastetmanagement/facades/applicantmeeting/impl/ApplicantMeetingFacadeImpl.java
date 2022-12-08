package com.bastet.bastetmanagement.facades.applicantmeeting.impl;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantMeetingDto;
import com.bastet.bastetmanagement.facades.applicantmeeting.ApplicantMeetingFacade;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApplicantMeetingFacadeImpl implements ApplicantMeetingFacade {
    @Override
    public ApplicantMeetingDto findById(UUID id) {
        return null;
    }
}
