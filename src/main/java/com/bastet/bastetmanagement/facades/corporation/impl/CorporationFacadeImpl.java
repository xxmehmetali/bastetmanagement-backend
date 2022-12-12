package com.bastet.bastetmanagement.facades.corporation.impl;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
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
    @Resource
    private CustomModelMapper customModelMapper;
    @Override
    public CorporationDto findById(UUID id) {
        return null;
    }

    @Override
    public CorporationSimplifiedDto findByIdSimplified(UUID id) {
        return customModelMapper.map(corporationService.findById(id), CorporationSimplifiedDto.class);
    }
}
