package com.bastet.bastetmanagement.services.currency.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.core.utilities.results.ResultUtil;
import com.bastet.bastetmanagement.daos.CurrencyDao;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Currency;
import com.bastet.bastetmanagement.services.currency.CurrencyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class CurrencyServiceImpl implements CurrencyService {
    @Resource
    private CurrencyDao currencyDao;
    @Override
    public Currency findById(UUID id){
        return currencyDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Currency not found."));
    }

    @Override
    public Page<Currency> findAllPaged(Pageable pageable) {
        return currencyDao.findAll(pageable);
    }

    @Override
    public List<Currency> findAll() {
        return currencyDao.findAll();
    }

    @Override
    public boolean add(Currency currency) {
        return ResultUtil.extractSuccess(currencyDao.save(currency));
    }

    @Override
    public boolean deleteById(UUID id) {
        currencyDao.deleteById(id);
        return ! currencyDao.existsById(id);
    }
}
