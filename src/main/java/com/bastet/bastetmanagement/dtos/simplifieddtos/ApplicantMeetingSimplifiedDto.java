package com.bastet.bastetmanagement.dtos.simplifieddtos;

import com.bastet.bastetmanagement.dtos.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantMeetingSimplifiedDto extends Dto {
    private UUID id;

    private MeetingPlatformSimplifiedDto meetingPlatform;

    private Date beginHour;

    private Date endHour;

    private EmployeeSimplifiedDto meetingOwner;

}
