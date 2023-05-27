package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.MeetingDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Meeting;
import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                EmployeeMapper.class,
                MeetingPlatformMapper.class
        }
)
public interface MeetingMapper {
    //xxxx 1693
    @Mappings({
            @Mapping(source = "meetingPlatform", target = "meetingPlatform", qualifiedByName = "meetingPlatformToMeetingPlatformDto"),
            @Mapping(source = "meetingOwner", target = "meetingOwner", qualifiedByName = "employeeToEmployeeDto")
    })
    MeetingDto meetingToMeetingDto(Meeting meeting);

    @Mapping(ignore = true, target = "id")
    @Mapping(source = "meetingOwner", target = "meetingOwner", qualifiedByName = "employeeDtoToEmployeeIdStatic")
    @Mapping(source = "meetingPlatform", target = "meetingPlatform", qualifiedByName = "meetingPlatformDtoToMeetingPlatformIdStatic")
    Meeting meetingDtoToMeeting(MeetingDto meetingDto);

    @Named("meetingDtoToMeetingIdStatic")
    Meeting meetingDtoToMeetingIdStatic(MeetingDto meetingDto);

    MeetingSimplifiedDto meetingToMeetingSimplifiedDto(Meeting meeting);
    Meeting meetingSimplifiedDtoToMeeting(MeetingSimplifiedDto meetingSimplifiedDto);
    //list versions
    List<Meeting> meetingDtoListToMeetingList(List<MeetingDto> meetingDtos);
    List<MeetingDto> meetingListToMeetingDtoList(List<Meeting> meetings);

}
