package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.basedtos.MeetingPlatformDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.MeetingPlatformSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingPlatformSimplifiedDto;
import com.bastet.bastetmanagement.models.*;
import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface MeetingPlatformMapper {
    MeetingPlatformDto meetingPlatformToMeetingPlatformDto(MeetingPlatform meetingPlatform);

    @Mapping(ignore = true, target = "id")
    MeetingPlatform meetingPlatformDtoToMeetingPlatform(MeetingPlatformDto meetingPlatformDto);

    @Named("meetingPlatformDtoToMeetingPlatformOnlyId")
    default MeetingPlatform meetingPlatformDtoToMeetingPlatformOnlyId(MeetingPlatformDto meetingPlatformDto){
        MeetingPlatform meetingPlatform = new MeetingPlatform();
        meetingPlatform.setId( meetingPlatformDto.getId() );
        return meetingPlatform;
    }

    @Named("meetingPlatformDtoToMeetingPlatformIdStatic")
    MeetingPlatform meetingPlatformDtoToMeetingPlatformIdStatic(MeetingPlatformDto meetingPlatformDto);

    MeetingPlatformSelectElementDto meetingToMeetingPlatformSelectElementDto(MeetingPlatform meetingPlatform);
    MeetingPlatformSimplifiedDto meetingPlatformToMeetingPlatformSimplifiedDto(MeetingPlatform meetingPlatform);
    MeetingPlatform meetingPlatformSimplifiedDtoToMeetingPlatform(MeetingPlatformSimplifiedDto meetingPlatformSimplifiedDto);
    //list versions
    List<MeetingPlatform> meetingPlatformDtoListToMeetingPlatformList(List<MeetingPlatformDto> meetingPlatformDtos);
    List<MeetingPlatformDto> meetingPlatformListToMeetingPlatformDtoList(List<MeetingPlatform> meetingPlatforms);
    List<MeetingPlatformSelectElementDto> meetingPlatformListToMeetingPlatformSelectElementDtoList(List<MeetingPlatform> meetingPlatforms);

}
