package com.bastet.bastetmanagement.dtos.basedtos;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
public class ApplicantMeetingDto {
    private UUID id;

    private ApplicantDto applicant;

    private MeetingPlatformDto meetingPlatform;

    private Date beginHour;
    private Date endHour;
    private Date createdAt;
    private Date updatedAt;
    private EmployeeDto meetingOwner;


}
