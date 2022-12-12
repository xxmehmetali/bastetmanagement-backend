package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.OccupationDto;
import com.bastet.bastetmanagement.models.Occupation;
import org.mapstruct.Mapper;

@Mapper
public interface OccupationMapper {
    OccupationDto occupationToOccupationDto(Occupation occupation);
    Occupation occupationDtoToOccupation(OccupationDto occupationDto);
}
