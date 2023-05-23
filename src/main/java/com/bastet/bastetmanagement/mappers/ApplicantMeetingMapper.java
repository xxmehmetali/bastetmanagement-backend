package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantMeetingDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ApplicantMeetingSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ApplicantMeetingSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.ApplicantMeeting;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                MeetingPlatformMapper.class,
                EmployeeMapper.class,
                ApplicantMapper.class
        }
)
public interface ApplicantMeetingMapper {
    ApplicantMeetingDto applicantMeetingToApplicantMeetingDto(ApplicantMeeting applicantMeeting);

    @Mapping(ignore = true, target = "id")
    @Mappings({
            @Mapping(source = "meetingOwner", target = "meetingOwner", qualifiedByName = "employeeDtoToEmployeeOnlyId"),
            @Mapping(source = "meetingPlatform", target = "meetingPlatform", qualifiedByName = "meetingPlatformDtoToMeetingPlatformOnlyId"),
            @Mapping(source = "applicant", target = "applicant", qualifiedByName = "applicantDtoToApplicantOnlyId")
    })
    ApplicantMeeting applicantMeetingDtoToApplicantMeeting(ApplicantMeetingDto applicantMeetingDto);

    @Named("applicantMeetingDtoToApplicantMeetingIdStatic")
    ApplicantMeeting applicantMeetingDtoToApplicantMeetingIdStatic(ApplicantMeetingDto applicantMeetingDto);

    @Mapping(source = "applicant.applicantMeeting.id", target = "id")
    @Mapping(target = "applicantFullName", expression = "java(applicant.getName() + ' ' + applicant.getSurname() + ' ' + '-' + ' ' + applicant.getPhoneNumber())")
    ApplicantMeetingSelectElementDto applicantToApplicantMeetingSelectElementDto(Applicant applicant);

    ApplicantMeetingSimplifiedDto applicantMeetingToApplicantMeetingSimplifiedDto(ApplicantMeeting applicantMeeting);

    ApplicantMeeting applicantMeetingSimplifiedDtoToApplicantMeeting(ApplicantMeetingSimplifiedDto applicantMeetingSimplifiedDto);

    //list versions
    List<ApplicantMeeting> applicantMeetingDtoListToApplicantMeetingList(List<ApplicantMeetingDto> applicantMeetingDtos);

    List<ApplicantMeetingDto> applicantMeetingListToApplicantMeetingDtoList(List<ApplicantMeeting> applicantMeetings);

    List<ApplicantMeeting> applicantMeetingSimplifiedDtoListToApplicantMeetingList(List<ApplicantMeetingSimplifiedDto> applicantMeetingSimplifiedDtos);

    List<ApplicantMeetingSimplifiedDto> applicantMeetingListToApplicantMeetingSimplifiedDtoList(List<ApplicantMeeting> applicantMeetings);


}
