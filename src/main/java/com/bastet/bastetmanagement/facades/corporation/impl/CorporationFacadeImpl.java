package com.bastet.bastetmanagement.facades.corporation.impl;

import com.bastet.bastetmanagement.dtos.basedtos.CorporationDto;
import com.bastet.bastetmanagement.facades.corporation.CorporationFacade;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CorporationFacadeImpl implements CorporationFacade {
    @Override
    public CorporationDto findById(UUID id) {
        return null;
    }
}
