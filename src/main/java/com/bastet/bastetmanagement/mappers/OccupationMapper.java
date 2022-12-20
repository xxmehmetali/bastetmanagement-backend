package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.OccupationDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.OccupationSimplifiedDto;
import com.bastet.bastetmanagement.models.Occupation;
import org.mapstruct.Mapper;

@Mapper
public interface OccupationMapper {
    OccupationDto occupationToOccupationDto(Occupation occupation);
    Occupation occupationDtoToOccupation(OccupationDto occupationDto);
    OccupationSimplifiedDto occupationToOccupationSimplifiedDto(Occupation occupation);
    Occupation occupationSimplifiedDtoToOccupation(OccupationSimplifiedDto occupationSimplifiedDto);
}
