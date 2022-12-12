package com.bastet.bastetmanagement.dtos.simplifieddtos;

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
public class MeetingSimplifiedDto {
    private UUID id;

    private EmployeeSimplifiedDto meetingOwner;

    private String meetingUrl;

    private Date beginHour;

    private Date endHour;

//    private List<EmployeeDto> attendants;

}
