package com.bastet.bastetmanagement.services.applicantmeeting;

import com.bastet.bastetmanagement.models.ApplicantMeeting;

import java.util.UUID;

public interface ApplicantMeetingService {
    public ApplicantMeeting findById(UUID id);

}
