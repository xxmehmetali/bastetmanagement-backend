package com.bastet.bastetmanagement.facades.occupation;

import com.bastet.bastetmanagement.dtos.basedtos.OccupationDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.OccupationSimplifiedDto;

import java.util.UUID;

public interface OccupationFacade {
    OccupationDto findById(UUID id);
    OccupationSimplifiedDto findByIdSimplified(UUID id);
}
