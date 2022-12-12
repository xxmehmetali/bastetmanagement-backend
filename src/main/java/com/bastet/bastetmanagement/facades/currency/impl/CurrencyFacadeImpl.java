package com.bastet.bastetmanagement.facades.currency.impl;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.dtos.basedtos.CurrencyDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CurrencySimplifiedDto;
import com.bastet.bastetmanagement.facades.currency.CurrencyFacade;
import com.bastet.bastetmanagement.services.currency.CurrencyService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class CurrencyFacadeImpl implements CurrencyFacade {
    @Resource
    private CurrencyService currencyService;
    @Resource
    private CustomModelMapper customModelMapper;
    @Override
    public CurrencyDto findById(UUID id) {
        return null;
    }

    @Override
    public CurrencySimplifiedDto findByIdSimplified(UUID id) {
        return customModelMapper.map(currencyService.findById(id), CurrencySimplifiedDto.class);
    }
}
