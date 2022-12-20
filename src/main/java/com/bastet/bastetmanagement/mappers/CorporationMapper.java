package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.CorporationDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CorporationSimplifiedDto;
import com.bastet.bastetmanagement.models.Corporation;
import org.mapstruct.Mapper;

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
}
