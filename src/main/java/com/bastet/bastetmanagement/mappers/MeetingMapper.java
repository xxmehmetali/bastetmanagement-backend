package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.MeetingDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Meeting;
import org.mapstruct.Mapper;

import java.util.List;

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
    //list versions
    List<Meeting> meetingDtoListToMeetingList(List<MeetingDto> meetingDtos);
    List<MeetingDto> meetingListToMeetingDtoList(List<Meeting> meetings);

}
