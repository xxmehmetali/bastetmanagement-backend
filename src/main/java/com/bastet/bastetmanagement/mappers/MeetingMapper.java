package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.MeetingDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingSimplifiedDto;
import com.bastet.bastetmanagement.models.Meeting;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {
                EmployeeMapper.class,
                MeetingPlatformMapper.class
        }
)
public interface MeetingMapper {
    MeetingDto meetingToMeetingDto(Meeting meeting);
    Meeting meetingDtoToMeeting(MeetingDto meetingDto);
    MeetingSimplifiedDto meetingToMeetingSimplifiedDto(Meeting meeting);
    Meeting meetingSimplifiedDtoToMeeting(MeetingSimplifiedDto meetingSimplifiedDto);
}
