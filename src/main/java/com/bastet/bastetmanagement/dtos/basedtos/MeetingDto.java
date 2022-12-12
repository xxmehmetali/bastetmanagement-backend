package com.bastet.bastetmanagement.dtos.basedtos;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MeetingDto {
    private UUID id;

    private EmployeeDto meetingOwner;

    private MeetingPlatformDto meetingPlatform;

    private String meetingUrl;

    private Date beginHour;

    private Date endHour;

//    private List<EmployeeDto> attendants;

}
