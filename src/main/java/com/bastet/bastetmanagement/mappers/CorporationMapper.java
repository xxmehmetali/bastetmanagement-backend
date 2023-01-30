package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.CorporationDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CorporationSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Corporation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                ProjectMapper.class
        }
)
public interface CorporationMapper {
    CorporationDto corporationToCorporationDto(Corporation corporation);
    Corporation corporationDtoToCorporation(CorporationDto corporationDto);
    CorporationSimplifiedDto corporationToCorporationSimplifiedDto(Corporation corporation);
    Corporation corporationSimplifiedDtoToCorporation(CorporationSimplifiedDto corporationSimplifiedDto);
    //list versions
    List<Corporation> corporationDtoListToCorporationList(List<CorporationDto> corporationDtos);
    List<CorporationDto> corporationListToCorporationDtoList(List<Corporation> corporations);

}
