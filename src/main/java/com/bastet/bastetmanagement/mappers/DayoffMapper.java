package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.DayoffDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.DayoffSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Dayoff;
import org.mapstruct.Mapper;

import java.util.List;

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
    //list versions
    List<Dayoff> dayoffDtoListToDayoffList(List<DayoffDto> dayoffDtos);
    List<DayoffDto> dayoffListToDayoffDtoList(List<Dayoff> dayoffs);

}
