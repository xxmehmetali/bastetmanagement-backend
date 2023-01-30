package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantMeetingDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ApplicantMeetingSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.ApplicantMeeting;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                MeetingPlatformMapper.class,
                EmployeeMapper.class,
        }
)
public interface ApplicantMeetingMapper {
    ApplicantMeetingDto applicantMeetingToApplicantMeetingDto(ApplicantMeeting applicantMeeting);
    ApplicantMeeting applicantMeetingDtoToApplicantMeeting(ApplicantMeetingDto applicantMeetingDto);
    ApplicantMeetingSimplifiedDto applicantMeetingToApplicantMeetingSimplifiedDto(ApplicantMeeting applicantMeeting);
    ApplicantMeeting applicantMeetingSimplifiedDtoToApplicantMeeting(ApplicantMeetingSimplifiedDto applicantMeetingSimplifiedDto);
    //list versions
    List<Applicant> applicantMeetingDtoListToApplicantMeetingList(List<ApplicantDto> applicantDtos);
    List<ApplicantDto> applicantMeetingListToApplicantMeetingDtoList(List<Applicant> applicants);
}
