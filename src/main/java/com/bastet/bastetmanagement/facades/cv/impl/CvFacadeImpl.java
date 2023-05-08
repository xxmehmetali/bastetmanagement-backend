package com.bastet.bastetmanagement.facades.cv.impl;

import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.CurrencyDto;
import com.bastet.bastetmanagement.mappers.CvMapper;

import com.bastet.bastetmanagement.core.utilities.results.dataresults.DataResult;
import com.bastet.bastetmanagement.core.utilities.results.dataresults.ErrorDataResult;
import com.bastet.bastetmanagement.core.utilities.results.dataresults.SuccessDataResult;
import com.bastet.bastetmanagement.dtos.basedtos.CvDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CvSimplifiedDto;
import com.bastet.bastetmanagement.facades.cv.CvFacade;
import com.bastet.bastetmanagement.models.Cv;
import com.bastet.bastetmanagement.services.cv.CvService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class CvFacadeImpl implements CvFacade {
    @Resource
    CvService cvService;

    @Resource
    private CvMapper cvMapper;

    @Override
    public CvDto findById(UUID id) {
        return cvMapper.cvToCvDto(cvService.findById(id));
    }

    @Override
    public CvSimplifiedDto findByIdSimplified(UUID id) {
        return cvMapper.cvToCvSimplifiedDto(cvService.findById(id));
    }

    @Override
    public Page<CvDto> findAllPaged(Pageable pageable) {
        return cvService.findAllPaged(pageable).map(cv -> cvMapper.cvToCvDto(cv));
    }

    @Override
    public Page<CvSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return cvService.findAllPaged(pageable).map(cv -> cvMapper.cvToCvSimplifiedDto(cv));
    }

    @Override
    public List<? extends Dto> findAllForSelectElement() {
        return null;
    }
}
