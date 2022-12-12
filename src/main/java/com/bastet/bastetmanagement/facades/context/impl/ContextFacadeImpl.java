package com.bastet.bastetmanagement.facades.context.impl;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.dtos.basedtos.ContextDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ContextSimplifiedDto;
import com.bastet.bastetmanagement.facades.context.ContextFacade;
import com.bastet.bastetmanagement.services.context.ContextService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class ContextFacadeImpl implements ContextFacade {
    @Resource
    private ContextService contextService;
    @Resource
    private CustomModelMapper customModelMapper;
    @Override
    public ContextDto findById(UUID id) {
        return null;
    }

    @Override
    public ContextSimplifiedDto findByIdSimplified(UUID id) {
        return customModelMapper.map(contextService.findById(id), ContextSimplifiedDto.class);
    }
}
