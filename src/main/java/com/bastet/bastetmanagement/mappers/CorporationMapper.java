package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.ContextDto;
import com.bastet.bastetmanagement.dtos.basedtos.CorporationDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CorporationSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Context;
import com.bastet.bastetmanagement.models.Corporation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                ProjectMapper.class
        }
)
public interface CorporationMapper {
    CorporationDto corporationToCorporationDto(Corporation corporation);

    @Mapping(ignore = true, target = "id")
    Corporation corporationDtoToCorporation(CorporationDto corporationDto);

    @Named("corporationDtoToCorporationIdStatic")
    Corporation corporationDtoToCorporationIdStatic(CorporationDto corporationDto);

    @Named("corporationDtoToCorporationOnlyId")
    default Corporation corporationDtoToCorporationOnlyId(CorporationDto corporationDto){
        Corporation corporation = new Corporation();
        corporation.setId( corporationDto.getId() );
        return corporation;
    }

    @Named("corporationDtoToCorporationForUpdate")
    Corporation corporationDtoToCorporationForUpdate(CorporationDto corporationDto);

    CorporationSimplifiedDto corporationToCorporationSimplifiedDto(Corporation corporation);
    Corporation corporationSimplifiedDtoToCorporation(CorporationSimplifiedDto corporationSimplifiedDto);
    //list versions
    List<Corporation> corporationDtoListToCorporationList(List<CorporationDto> corporationDtos);
    List<CorporationDto> corporationListToCorporationDtoList(List<Corporation> corporations);

    CorporationSelectElementDto corporationToCorporationSelectElementDto(Corporation corporation);

    List<CorporationSelectElementDto> corporationListToCorporationSelectElementDtoList(List<Corporation> corporations);

}
