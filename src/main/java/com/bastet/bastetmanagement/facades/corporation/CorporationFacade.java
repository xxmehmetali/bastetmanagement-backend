package com.bastet.bastetmanagement.facades.corporation;

import com.bastet.bastetmanagement.dtos.basedtos.CorporationDto;

import java.util.UUID;

public interface CorporationFacade {
    CorporationDto findById(UUID id);
}
