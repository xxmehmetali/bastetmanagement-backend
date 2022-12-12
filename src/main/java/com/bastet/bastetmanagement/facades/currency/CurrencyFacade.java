package com.bastet.bastetmanagement.facades.currency;

import com.bastet.bastetmanagement.dtos.basedtos.CurrencyDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CurrencySimplifiedDto;

import java.util.UUID;

public interface CurrencyFacade {
    CurrencyDto findById(UUID id);
    CurrencySimplifiedDto findByIdSimplified(UUID id);
}
