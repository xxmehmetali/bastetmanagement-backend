package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.MeetingPlatformDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingPlatformSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.MeetingPlatform;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MeetingPlatformMapper {
    MeetingPlatformDto meetingPlatformToMeetingPlatformDto(MeetingPlatform meetingPlatform);
    MeetingPlatform meetingPlatformDtoToMeetingPlatform(MeetingPlatformDto meetingPlatformDto);
    MeetingPlatformSimplifiedDto meetingPlatformToMeetingPlatformSimplifiedDto(MeetingPlatform meetingPlatform);
    MeetingPlatform meetingPlatformSimplifiedDtoToMeetingPlatform(MeetingPlatformSimplifiedDto meetingPlatformSimplifiedDto);
    //list versions
    List<MeetingPlatform> meetingPlatformDtoListToMeetingPlatformList(List<MeetingPlatformDto> meetingPlatformDtos);
    List<MeetingPlatformDto> meetingPlatformListToMeetingPlatformDtoList(List<MeetingPlatform> meetingPlatforms);

}
