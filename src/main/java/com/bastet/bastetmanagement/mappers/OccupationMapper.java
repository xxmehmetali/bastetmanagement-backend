package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.basedtos.OccupationDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.OccupationSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.OccupationSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.Employee;
import com.bastet.bastetmanagement.models.Occupation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface OccupationMapper {
    OccupationDto occupationToOccupationDto(Occupation occupation);

    @Mapping(ignore = true, target = "id")
    Occupation occupationDtoToOccupation(OccupationDto occupationDto);

    @Named("occupationDtoToOccupationIdStatic")
    Occupation occupationDtoToOccupationIdStatic(OccupationDto occupationDto);

    @Named("occupationDtoToOccupationOnlyId")
    default Occupation occupationDtoToOccupationOnlyId(OccupationDto occupationDto){
        Occupation occupation = new Occupation();
        occupation.setId( occupationDto.getId() );
        return occupation;
    }

    OccupationSimplifiedDto occupationToOccupationSimplifiedDto(Occupation occupation);
    Occupation occupationSimplifiedDtoToOccupation(OccupationSimplifiedDto occupationSimplifiedDto);
    //list versions
    List<Occupation> occupationDtoListToOccupationList(List<OccupationDto> occupationDtos);
    List<OccupationDto> occupationListToOccupationDtoList(List<Occupation> occupations);
    OccupationSelectElementDto occupationToOccupationSelectElementDto(Occupation occupation);

}
