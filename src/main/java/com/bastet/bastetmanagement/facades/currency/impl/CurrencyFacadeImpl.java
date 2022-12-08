package com.bastet.bastetmanagement.facades.currency.impl;

import com.bastet.bastetmanagement.dtos.basedtos.CurrencyDto;
import com.bastet.bastetmanagement.facades.currency.CurrencyFacade;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CurrencyFacadeImpl implements CurrencyFacade {
    @Override
    public CurrencyDto findById(UUID id) {
        return null;
    }
}
