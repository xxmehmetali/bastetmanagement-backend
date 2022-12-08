package com.bastet.bastetmanagement.facades.occupation;

import com.bastet.bastetmanagement.dtos.basedtos.OccupationDto;

import java.util.UUID;

public interface OccupationFacade {
    OccupationDto findById(UUID id);
}
