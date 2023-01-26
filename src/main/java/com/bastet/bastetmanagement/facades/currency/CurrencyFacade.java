package com.bastet.bastetmanagement.facades.currency;

import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.CurrencyDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CurrencySimplifiedDto;
import com.bastet.bastetmanagement.facades.GenericFacade;

import java.util.UUID;

public interface CurrencyFacade extends GenericFacade<Dto> {
    CurrencyDto findById(UUID id);
    CurrencySimplifiedDto findByIdSimplified(UUID id);
}
