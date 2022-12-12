package com.bastet.bastetmanagement.dtos.basedtos;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantMeetingDto {
    private UUID id;

    private MeetingPlatformDto meetingPlatform;

    private Date beginHour;

    private Date endHour;

    private EmployeeDto meetingOwner;

    private Date createdAt;

    private Date updatedAt;

}
