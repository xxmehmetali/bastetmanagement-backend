package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantMeetingDto;
import com.bastet.bastetmanagement.models.ApplicantMeeting;
import org.mapstruct.Mapper;

@Mapper
public interface ApplicantMeetingMapper {
    ApplicantMeetingDto applicantMeetingToApplicantMeetingDto(ApplicantMeeting applicantMeeting);
    ApplicantMeeting applicantMeetingDtoToApplicantMeeting(ApplicantMeetingDto applicantMeetingDto);
}
