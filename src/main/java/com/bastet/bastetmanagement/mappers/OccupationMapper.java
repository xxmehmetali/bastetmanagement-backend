package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.OccupationDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.OccupationSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.OccupationSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.Occupation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OccupationMapper {
    OccupationDto occupationToOccupationDto(Occupation occupation);
    Occupation occupationDtoToOccupation(OccupationDto occupationDto);
    OccupationSimplifiedDto occupationToOccupationSimplifiedDto(Occupation occupation);
    Occupation occupationSimplifiedDtoToOccupation(OccupationSimplifiedDto occupationSimplifiedDto);
    //list versions
    List<Occupation> occupationDtoListToOccupationList(List<OccupationDto> occupationDtos);
    List<OccupationDto> occupationListToOccupationDtoList(List<Occupation> occupations);
    List<OccupationSelectElementDto> occupationListToOccupationSelectElementDtoList(List<Occupation> occupations);

}
