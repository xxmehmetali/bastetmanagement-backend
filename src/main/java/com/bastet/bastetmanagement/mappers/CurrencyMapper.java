package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.CurrencyDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CurrencySimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Currency;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CurrencyMapper {
    CurrencyDto currencyToCurrencyDto(Currency currency);
    Currency currencyDtoToCurrency(CurrencyDto currencyDto);
    CurrencySimplifiedDto currencyToCurrencySimplifiedDto(Currency currency);
    Currency currencySimplifiedDtoToCurrency(CurrencySimplifiedDto currencySimplifiedDto);
    //list versions
    List<Currency> currencyDtoListToCurrencyList(List<CurrencyDto> currencyDtos);
    List<CurrencyDto> currencyListToCurrencyDtoList(List<Currency> currencies);

}