package com.bastet.bastetmanagement.facades.context.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.ContextDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ContextSimplifiedDto;
import com.bastet.bastetmanagement.facades.context.ContextFacade;
import com.bastet.bastetmanagement.mappers.ContextMapper;
import com.bastet.bastetmanagement.models.Context;
import com.bastet.bastetmanagement.services.context.ContextService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class ContextFacadeImpl implements ContextFacade {
    @Resource
    private ContextService contextService;

    @Resource
    private ContextMapper contextMapper;

    @Override
    public ContextDto findById(UUID id) {
        return null;
    }

    @Override
    public ContextSimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }

    @Override
    public Page<ContextDto> findAllPaged(Pageable pageable) {
        return null;
    }

    @Override
    public Page<ContextSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return null;
    }
}
