package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.daos.CurrencyDao;
import com.bastet.bastetmanagement.models.Currency;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Resource
    private CurrencyDao currencyDao;

    @GetMapping("/findById/{id}")
    public Currency findById(@PathVariable("id")UUID id){
        return currencyDao.findById(id).orElse(null);
    }
    @GetMapping("/findByCurrencySymbol/{currencySymbol}")
    public Currency findByCurrencySymbol(@PathVariable("currencySymbol")String currencySymbol){
        return currencyDao.findCurrencyByCurrencySymbol(currencySymbol);
    }

}
