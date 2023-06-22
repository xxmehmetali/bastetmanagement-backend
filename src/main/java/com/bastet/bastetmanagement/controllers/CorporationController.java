package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.constants.ResultConstants;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.dtos.basedtos.CorporationDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.facades.corporation.CorporationFacade;
import com.bastet.bastetmanagement.models.Corporation;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/corporation")
public class CorporationController extends BaseController {
    @Resource
    private CorporationFacade corporationFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(corporationFacade.findById(id), ResultConstants.foundMessage(Corporation.class));
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(corporationFacade.findByIdSimplified(id), ResultConstants.foundMessage(Corporation.class));
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(corporationFacade.findAllPaged(pageable), ResultConstants.dataListedMessage(Corporation.class));
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(corporationFacade.findAllPagedSimplified(pageable), ResultConstants.dataListedMessage(Corporation.class));
    }

    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<CorporationSelectElementDto> corporationSelectElementDtos = (List<CorporationSelectElementDto>) corporationFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(corporationSelectElementDtos, ResultConstants.dataListedMessageForSelection(Corporation.class));
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public Result add(@RequestBody CorporationDto corporationDto) {
        boolean success = corporationFacade.add(corporationDto);
        return wrapResultWithMessage(success, ResultConstants.addedMessage(Corporation.class));
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam("id") UUID id) {
        boolean success = corporationFacade.deleteById(id);
        return wrapResultWithMessage(success, ResultConstants.deletedMessage(Corporation.class));
    }

    @PostMapping(value = "/update", consumes = "application/json")
    public Result update(@RequestBody CorporationDto corporationDto) {
        boolean success = corporationFacade.update(corporationDto);
        return wrapResultWithMessage(success, ResultConstants.updatedMessage(Corporation.class));
    }

}
