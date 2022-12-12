package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.MeetingPlatformDto;
import com.bastet.bastetmanagement.models.MeetingPlatform;
import org.mapstruct.Mapper;

@Mapper
public interface MeetingPlatformMapper {
    MeetingPlatformDto meetingPlatformToMeetingPlatformDto(MeetingPlatform meetingPlatform);
    MeetingPlatform meetingPlatformDtoToMeetingPlatform(MeetingPlatformDto meetingPlatformDto);
}
