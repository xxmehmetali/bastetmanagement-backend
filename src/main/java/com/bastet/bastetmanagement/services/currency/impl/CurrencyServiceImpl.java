package com.bastet.bastetmanagement.services.currency.impl;

import com.bastet.bastetmanagement.daos.CurrencyDao;
import com.bastet.bastetmanagement.models.Currency;
import com.bastet.bastetmanagement.services.currency.CurrencyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Log4j2
public class CurrencyServiceImpl implements CurrencyService {
    @Resource
    private CurrencyDao currencyDao;
    @Override
    public Currency findById(UUID id){
        Currency currency = currencyDao.findById(id).orElse(null);
        return currency;
    }
}
