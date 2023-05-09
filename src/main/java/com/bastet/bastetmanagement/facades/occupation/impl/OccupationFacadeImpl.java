package com.bastet.bastetmanagement.facades.occupation.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.basedtos.OccupationDto;
import com.bastet.bastetmanagement.dtos.selectdtos.OccupationSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.OccupationSimplifiedDto;
import com.bastet.bastetmanagement.facades.occupation.OccupationFacade;
import com.bastet.bastetmanagement.mappers.OccupationMapper;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Occupation;
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
        return occupationMapper.occupationToOccupationDto(occupationService.findById(id));
    }

    @Override
    public OccupationSimplifiedDto findByIdSimplified(UUID id) {
        return occupationMapper.occupationToOccupationSimplifiedDto(occupationService.findById(id));
    }

    @Override
    public Page<OccupationDto> findAllPaged(Pageable pageable) {
        return occupationService.findAllPaged(pageable).map(occupation -> occupationMapper.occupationToOccupationDto(occupation));
    }
    @Override
    public Page<OccupationSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return occupationService.findAllPaged(pageable).map(occupation -> occupationMapper.occupationToOccupationSimplifiedDto(occupation));
    }

    @Override
    public List<OccupationSelectElementDto> findAllForSelectElement(){
        List<Occupation> occupations = occupationService.findAll();
        return occupationMapper.occupationListToOccupationSelectElementDtoList(occupations);
    }}
