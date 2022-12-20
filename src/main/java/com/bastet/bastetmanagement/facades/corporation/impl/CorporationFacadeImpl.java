package com.bastet.bastetmanagement.facades.corporation.impl;


import com.bastet.bastetmanagement.dtos.basedtos.CorporationDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CorporationSimplifiedDto;
import com.bastet.bastetmanagement.facades.corporation.CorporationFacade;
import com.bastet.bastetmanagement.services.corporation.CorporationService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class CorporationFacadeImpl implements CorporationFacade {

    @Resource
    private CorporationService corporationService;

    @Override
    public CorporationDto findById(UUID id) {
        return null;
    }

    @Override
    public CorporationSimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }
}
