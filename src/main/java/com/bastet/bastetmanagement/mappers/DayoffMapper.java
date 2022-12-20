package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.DayoffDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.DayoffSimplifiedDto;
import com.bastet.bastetmanagement.models.Dayoff;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {
                EmployeeMapper.class
        }
)
public interface DayoffMapper {
    DayoffDto dayoffToDayoffDto(Dayoff dayoff);
    Dayoff dayoffDtoToDayoff(DayoffDto dayoffDto);
    DayoffSimplifiedDto dayoffToDayoffSimplifiedDto(Dayoff dayoff);
    Dayoff dayoffSimplifiedDtoToDayoff(DayoffSimplifiedDto dayoffSimplifiedDto);
}
