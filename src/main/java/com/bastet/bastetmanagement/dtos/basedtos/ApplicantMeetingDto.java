package com.bastet.bastetmanagement.dtos.basedtos;

import lombok.*;

import java.util.UUID;

@Data
public class ApplicantMeetingDto {
    private UUID id;

    private ApplicantDto applicant;

    private MeetingPlatformDto meetingPlatform;

}
