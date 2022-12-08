package com.bastet.bastetmanagement.facades.occupation.impl;

import com.bastet.bastetmanagement.dtos.basedtos.OccupationDto;
import com.bastet.bastetmanagement.facades.occupation.OccupationFacade;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OccupationFacadeImpl implements OccupationFacade {
    @Override
    public OccupationDto findById(UUID id) {
        return null;
    }
}
