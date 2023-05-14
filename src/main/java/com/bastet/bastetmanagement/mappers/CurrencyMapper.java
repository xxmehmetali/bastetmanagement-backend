package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.CurrencyDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CurrencySelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CurrencySimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface CurrencyMapper {
    CurrencyDto currencyToCurrencyDto(Currency currency);

    @Mapping(ignore = true, target = "id")
    Currency currencyDtoToCurrency(CurrencyDto currencyDto);

    @Named("currencyDtoToCurrencyIdStatic")
    Currency currencyDtoToCurrencyIdStatic(CurrencyDto currencyDto);

    @Named("currencyDtoToCurrencyOnlyId")
    default Currency currencyDtoToCurrencyOnlyId(CurrencyDto currencyDto) {
        Currency currency = new Currency();
        currency.setId( currencyDto.getId() );
        return currency;
    }

    CurrencySimplifiedDto currencyToCurrencySimplifiedDto(Currency currency);

    Currency currencySimplifiedDtoToCurrency(CurrencySimplifiedDto currencySimplifiedDto);

    //list versions
    List<Currency> currencyDtoListToCurrencyList(List<CurrencyDto> currencyDtos);

    List<CurrencyDto> currencyListToCurrencyDtoList(List<Currency> currencies);

    @Mappings({
            @Mapping(target = "currencyNameAndSymbol", expression = "java(currency.getCurrencyName() + ' ' + currency.getCurrencySymbol())")
    })
    CurrencySelectElementDto currencyToCurrencySelectElementDto(Currency currency);

}