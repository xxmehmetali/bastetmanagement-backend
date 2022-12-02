package com.bastet.bastetmanagement.dtos.basedtos;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class MeetingDto {
    private UUID id;

    private long meetingOwner;

    private MeetingPlatformDto meetingPlatform;

    private long meetingUrl;

    private Date beginHour;

    private Date endHour;

    private List<EmployeeDto> attendants;

}
