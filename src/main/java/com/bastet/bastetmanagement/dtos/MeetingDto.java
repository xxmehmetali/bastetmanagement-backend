package com.bastet.bastetmanagement.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
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
