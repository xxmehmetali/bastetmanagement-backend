package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.DayoffDto;
import com.bastet.bastetmanagement.models.Dayoff;
import org.mapstruct.Mapper;

@Mapper
public interface DayoffMapper {
    DayoffDto dayoffToDayoffDto(Dayoff dayoff);
    Dayoff dayoffDtoToDayoff(DayoffDto dayoffDto);
}
