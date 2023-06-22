package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.constants.ResultConstants;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.dtos.basedtos.CurrencyDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CurrencySelectElementDto;
import com.bastet.bastetmanagement.facades.currency.CurrencyFacade;
import com.bastet.bastetmanagement.models.Currency;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/currency")
public class CurrencyController extends BaseController {
    @Resource
    private CurrencyFacade currencyFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(currencyFacade.findById(id), ResultConstants.foundMessage(Currency.class));
    }

    /**
     * TO BE RETURNED
     */
    @GetMapping("/search")
    public Result findByCurrencySymbol(@RequestParam("currencySymbol") String currencySymbol) {
        return null;
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(currencyFacade.findByIdSimplified(id), ResultConstants.foundMessage(Currency.class));
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(currencyFacade.findAllPaged(pageable), ResultConstants.dataListedMessage(Currency.class));
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(currencyFacade.findAllPagedSimplified(pageable), ResultConstants.dataListedMessage(Currency.class));
    }

    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<CurrencySelectElementDto> currencySelectElementDtos = (List<CurrencySelectElementDto>) currencyFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(currencySelectElementDtos, ResultConstants.dataListedMessageForSelection(Currency.class));
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public Result add(@RequestBody CurrencyDto currencyDto) {
        boolean success = currencyFacade.add(currencyDto);
        return wrapResultWithMessage(success, ResultConstants.addedMessage(Currency.class));
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam("id") UUID id) {
        boolean success = currencyFacade.deleteById(id);
        return wrapResultWithMessage(success, ResultConstants.deletedMessage(Currency.class));
    }

    @PostMapping(value = "/update", consumes = "application/json")
    public Result update(@RequestBody CurrencyDto currencyDto) {
        boolean success = currencyFacade.update(currencyDto);
        return wrapResultWithMessage(success, ResultConstants.updatedMessage(Currency.class));
    }

}
