package com.bastet.bastetmanagement.services.currency;

import com.bastet.bastetmanagement.daos.CurrencyDao;
import com.bastet.bastetmanagement.models.Currency;

import javax.annotation.Resource;
import java.util.UUID;

public interface CurrencyService {
    Currency findById(UUID id);
}
