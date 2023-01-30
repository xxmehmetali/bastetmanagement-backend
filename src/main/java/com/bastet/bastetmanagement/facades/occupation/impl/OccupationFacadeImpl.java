package com.bastet.bastetmanagement.facades.occupation.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.basedtos.OccupationDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.OccupationSimplifiedDto;
import com.bastet.bastetmanagement.facades.occupation.OccupationFacade;
import com.bastet.bastetmanagement.mappers.OccupationMapper;
import com.bastet.bastetmanagement.services.occupation.OccupationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class OccupationFacadeImpl implements OccupationFacade {
    @Resource
    private OccupationService occupationService;

    @Resource
    private OccupationMapper occupationMapper;

    @Override
    public OccupationDto findById(UUID id) {
        return null;
    }

    @Override
    public OccupationSimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }

    @Override
    public Page<OccupationDto> findAllPaged(Pageable pageable) {
        Page pageImpl = occupationService.findAllPaged(pageable);
        List<OccupationDto> dtos = occupationMapper.occupationListToOccupationDtoList(pageImpl.getContent());
        return new PageImpl<>(dtos, pageable, pageImpl.getTotalPages());

    }
    @Override
    public Page<OccupationSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return null;
    }
}
