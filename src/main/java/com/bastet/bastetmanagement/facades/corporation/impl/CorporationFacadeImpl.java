package com.bastet.bastetmanagement.facades.corporation.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.CorporationDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CorporationSimplifiedDto;
import com.bastet.bastetmanagement.facades.corporation.CorporationFacade;
import com.bastet.bastetmanagement.mappers.CorporationMapper;
import com.bastet.bastetmanagement.services.corporation.CorporationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class CorporationFacadeImpl implements CorporationFacade {

    @Resource
    private CorporationService corporationService;

    @Resource
    private CorporationMapper corporationMapper;

    @Override
    public CorporationDto findById(UUID id) {
        return corporationMapper.corporationToCorporationDto(corporationService.findById(id));
    }

    @Override
    public CorporationSimplifiedDto findByIdSimplified(UUID id) {
        return corporationMapper.corporationToCorporationSimplifiedDto(corporationService.findById(id));
    }

    @Override
    public Page<CorporationDto> findAllPaged(Pageable pageable) {
        return corporationService.findAllPaged(pageable).map(corporation -> corporationMapper.corporationToCorporationDto(corporation));
    }

    @Override
    public Page<CorporationSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return corporationService.findAllPaged(pageable).map(corporation -> corporationMapper.corporationToCorporationSimplifiedDto(corporation));
    }
}
