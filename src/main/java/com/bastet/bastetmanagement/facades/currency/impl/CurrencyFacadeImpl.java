package com.bastet.bastetmanagement.facades.currency.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.CurrencyDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CurrencySimplifiedDto;
import com.bastet.bastetmanagement.facades.currency.CurrencyFacade;
import com.bastet.bastetmanagement.mappers.CurrencyMapper;
import com.bastet.bastetmanagement.services.currency.CurrencyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class CurrencyFacadeImpl implements CurrencyFacade {
    @Resource
    private CurrencyService currencyService;

    @Resource
    private CurrencyMapper currencyMapper;

    @Override
    public CurrencyDto findById(UUID id) {
        return null;
    }

    @Override
    public CurrencySimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }

    @Override
    public Page<CurrencyDto> findAllPaged(Pageable pageable) {
        Page pageImpl = currencyService.findAllPaged(pageable);
        List<CurrencyDto> dtos = currencyMapper.currencyListToCurrencyDtoList(pageImpl.getContent());
        return new PageImpl<>(dtos, pageable, pageImpl.getTotalPages());
    }

    @Override
    public Page<CurrencySimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return null;
    }
}
