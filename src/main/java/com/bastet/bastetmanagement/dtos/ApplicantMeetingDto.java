package com.bastet.bastetmanagement.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
public class ApplicantMeetingDto {
    private UUID id;

    private ApplicantDto applicant;

    private MeetingPlatformDto meetingPlatform;

}
