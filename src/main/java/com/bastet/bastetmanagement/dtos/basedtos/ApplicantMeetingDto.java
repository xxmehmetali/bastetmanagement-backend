package com.bastet.bastetmanagement.dtos.basedtos;

import com.bastet.bastetmanagement.dtos.Dto;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantMeetingDto extends Dto {
    private UUID id;

    private MeetingPlatformDto meetingPlatform;

    private Date beginHour;

    private Date endHour;

    private EmployeeDto meetingOwner;

    private ApplicantDto applicant;

    private Date createdAt;

    private Date updatedAt;

}
