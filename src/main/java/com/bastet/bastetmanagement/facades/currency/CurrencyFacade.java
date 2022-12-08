package com.bastet.bastetmanagement.facades.currency;

import com.bastet.bastetmanagement.dtos.basedtos.CurrencyDto;

import java.util.UUID;

public interface CurrencyFacade {
    CurrencyDto findById(UUID id);
}
