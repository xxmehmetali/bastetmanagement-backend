package com.bastet.bastetmanagement.facades.occupation.impl;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.dtos.basedtos.OccupationDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.OccupationSimplifiedDto;
import com.bastet.bastetmanagement.facades.occupation.OccupationFacade;
import com.bastet.bastetmanagement.services.occupation.OccupationService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class OccupationFacadeImpl implements OccupationFacade {
    @Resource
    private OccupationService occupationService;
    @Resource
    private CustomModelMapper customModelMapper;
    @Override
    public OccupationDto findById(UUID id) {
        return null;
    }

    @Override
    public OccupationSimplifiedDto findByIdSimplified(UUID id) {
        return customModelMapper.map(occupationService.findById(id), OccupationSimplifiedDto.class);
    }
}
