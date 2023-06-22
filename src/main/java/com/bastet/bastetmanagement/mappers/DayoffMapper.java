package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.DayoffDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.DayoffSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Dayoff;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                EmployeeMapper.class
        }
)
public interface DayoffMapper {
    @Mappings({
            @Mapping(source = "employee", target = "employee", qualifiedByName = "employeeToEmployeeDto")
    })
    DayoffDto dayoffToDayoffDto(Dayoff dayoff);

    @Mapping(ignore = true, target = "id")
    @Mappings({
            @Mapping(source = "employee", target = "employee", qualifiedByName = "employeeDtoToEmployeeOnlyId"),
    })
    Dayoff dayoffDtoToDayoff(DayoffDto dayoffDto);

    @Mappings({
            @Mapping(source = "employee", target = "employee", qualifiedByName = "employeeDtoToEmployeeOnlyId")
    })
    @Named("dayoffDtoToDayoffForUpdate")
    Dayoff dayoffDtoToDayoffForUpdate(DayoffDto dayoffDto);

    @Named("dayoffDtoToDayoffIdStatic")
    Dayoff dayoffDtoToDayoffIdStatic(DayoffDto dayoffDto);

    DayoffSimplifiedDto dayoffToDayoffSimplifiedDto(Dayoff dayoff);
    Dayoff dayoffSimplifiedDtoToDayoff(DayoffSimplifiedDto dayoffSimplifiedDto);
    //list versions
    List<Dayoff> dayoffDtoListToDayoffList(List<DayoffDto> dayoffDtos);
    List<DayoffDto> dayoffListToDayoffDtoList(List<Dayoff> dayoffs);

}
