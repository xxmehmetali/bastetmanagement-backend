package com.bastet.bastetmanagement.facades.dayoff;

import com.bastet.bastetmanagement.dtos.basedtos.DayoffDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.DayoffSimplifiedDto;
import com.bastet.bastetmanagement.models.Dayoff;

import java.util.UUID;

public interface DayoffFacade {
    DayoffDto findById(UUID id);
    DayoffSimplifiedDto findByIdSimplified(UUID id);
}
