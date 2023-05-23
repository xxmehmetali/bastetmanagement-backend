package com.bastet.bastetmanagement.facades.dayoff.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.CvDto;
import com.bastet.bastetmanagement.dtos.basedtos.DayoffDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.DayoffSimplifiedDto;
import com.bastet.bastetmanagement.facades.dayoff.DayoffFacade;
import com.bastet.bastetmanagement.mappers.DayoffMapper;
import com.bastet.bastetmanagement.models.Dayoff;
import com.bastet.bastetmanagement.services.dayoff.DayoffService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class DayoffFacadeImpl implements DayoffFacade {
    @Resource
    private DayoffService dayoffService;

    @Resource
    private DayoffMapper dayoffMapper;

    @Override
    public DayoffDto findById(UUID id) {
        return dayoffMapper.dayoffToDayoffDto(dayoffService.findById(id));
    }

    @Override
    public DayoffSimplifiedDto findByIdSimplified(UUID id) {
        return dayoffMapper.dayoffToDayoffSimplifiedDto(dayoffService.findById(id));
    }

    @Override
    public Page<DayoffDto> findAllPaged(Pageable pageable) {
        return dayoffService.findAllPaged(pageable).map(dayoff -> dayoffMapper.dayoffToDayoffDto(dayoff));
    }

    @Override
    public Page<DayoffSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return dayoffService.findAllPaged(pageable).map(dayoff -> dayoffMapper.dayoffToDayoffSimplifiedDto(dayoff));
    }

    @Override
    public List<? extends Dto> findAllForSelectElement() {
        return null;
    }

    @Override
    public boolean add(Dto dto) {
        Dayoff dayoff = dayoffMapper.dayoffDtoToDayoff((DayoffDto) dto);
        boolean success = dayoffService.add(dayoff);
        return success;
    }
    @Override
    public boolean deleteById(UUID id) {
        return dayoffService.deleteById(id);
    }
}
