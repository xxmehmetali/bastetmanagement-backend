package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.CorporationDto;
import com.bastet.bastetmanagement.models.Corporation;
import org.mapstruct.Mapper;

@Mapper
public interface CorporationMapper {
    CorporationDto corporationToCorporationDto(Corporation corporation);
    Corporation corporationDtoToCorporation(CorporationDto corporationDto);
}
