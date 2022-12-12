package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.MeetingDto;
import com.bastet.bastetmanagement.models.Meeting;
import org.mapstruct.Mapper;

@Mapper
public interface MeetingMapper {
    MeetingDto meetingToMeetingDto(Meeting meeting);
    Meeting meetingDtoToMeeting(MeetingDto meetingDto);
}
