package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.MeetingPlatformDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingPlatformSimplifiedDto;
import com.bastet.bastetmanagement.models.MeetingPlatform;
import org.mapstruct.Mapper;

@Mapper
public interface MeetingPlatformMapper {
    MeetingPlatformDto meetingPlatformToMeetingPlatformDto(MeetingPlatform meetingPlatform);
    MeetingPlatform meetingPlatformDtoToMeetingPlatform(MeetingPlatformDto meetingPlatformDto);
    MeetingPlatformSimplifiedDto meetingPlatformToMeetingPlatformSimplifiedDto(MeetingPlatform meetingPlatform);
    MeetingPlatform meetingPlatformSimplifiedDtoToMeetingPlatform(MeetingPlatformSimplifiedDto meetingPlatformSimplifiedDto);
}
