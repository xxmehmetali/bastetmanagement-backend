package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.CurrencyDto;
import com.bastet.bastetmanagement.models.Currency;
import org.mapstruct.Mapper;

@Mapper
public interface CurrencyMapper {
    CurrencyDto currencyToCurrencyDto(Currency currency);
    Currency currencyDtoToCurrency(CurrencyDto currencyDto);
}