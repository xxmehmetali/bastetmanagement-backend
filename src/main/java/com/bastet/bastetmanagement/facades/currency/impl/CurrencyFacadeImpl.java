package com.bastet.bastetmanagement.facades.currency.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.CurrencyDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CurrencySelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CurrencySimplifiedDto;
import com.bastet.bastetmanagement.facades.currency.CurrencyFacade;
import com.bastet.bastetmanagement.mappers.CurrencyMapper;
import com.bastet.bastetmanagement.models.Currency;
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
        return currencyMapper.currencyToCurrencyDto(currencyService.findById(id));
    }

    @Override
    public CurrencySimplifiedDto findByIdSimplified(UUID id) {
        return currencyMapper.currencyToCurrencySimplifiedDto(currencyService.findById(id));
    }

    @Override
    public Page<CurrencyDto> findAllPaged(Pageable pageable) {
        return currencyService.findAllPaged(pageable).map(currency -> currencyMapper.currencyToCurrencyDto(currency));
    }

    @Override
    public Page<CurrencySimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return currencyService.findAllPaged(pageable).map(currency -> currencyMapper.currencyToCurrencySimplifiedDto(currency));
    }

    @Override
    public List<CurrencySelectElementDto> findAllForSelectElement(){
        List<Currency> currencies = currencyService.findAll();
        return currencyMapper.currencyListToCurrencySelectElementDtoList(currencies);
    }

    @Override
    public boolean add(Dto dto) {
        Currency currency = currencyMapper.currencyDtoToCurrency((CurrencyDto) dto);
        boolean success = currencyService.add(currency);
        return success;
    }
}
