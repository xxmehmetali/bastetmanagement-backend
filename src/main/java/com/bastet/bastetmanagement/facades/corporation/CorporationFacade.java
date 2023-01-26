package com.bastet.bastetmanagement.facades.corporation;

import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.CorporationDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CorporationSimplifiedDto;
import com.bastet.bastetmanagement.facades.GenericFacade;

import java.util.UUID;

public interface CorporationFacade extends GenericFacade<Dto> {
    CorporationDto findById(UUID id);
    CorporationSimplifiedDto findByIdSimplified(UUID id);
}
