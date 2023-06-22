package com.bastet.bastetmanagement.dtos.basedtos;

import com.bastet.bastetmanagement.core.enums.MeetingType;
import com.bastet.bastetmanagement.dtos.Dto;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MeetingDto extends Dto {
    private UUID id;

    private EmployeeDto meetingOwner;

    private MeetingPlatformDto meetingPlatform;

    private String meetingUrl;

    private Date beginHour;

    private Date endHour;

    private String topic;

    private String description;

    private MeetingType meetingType;

//    private List<EmployeeDto> attendants;

}
