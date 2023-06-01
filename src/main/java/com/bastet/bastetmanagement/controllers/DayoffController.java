package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.constants.ResultConstants;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.daos.DayOffDao;
import com.bastet.bastetmanagement.dtos.basedtos.BranchDto;
import com.bastet.bastetmanagement.dtos.basedtos.DayoffDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.DayoffSimplifiedDto;
import com.bastet.bastetmanagement.facades.dayoff.DayoffFacade;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Branch;
import com.bastet.bastetmanagement.models.Dayoff;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/dayoff")
public class DayoffController extends BaseController {
    @Resource
    private DayoffFacade dayoffFacade;


    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id")UUID id){
        return wrapSuccessDataResultWithMessage(dayoffFacade.findById(id), ResultConstants.foundMessage(Dayoff.class));
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage(dayoffFacade.findByIdSimplified(id), ResultConstants.foundMessage(Dayoff.class));
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable){
        return wrapSuccessDataResultWithMessage(dayoffFacade.findAllPaged(pageable), ResultConstants.dataListedMessage(Dayoff.class));
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable){
        return wrapSuccessDataResultWithMessage(dayoffFacade.findAllPagedSimplified(pageable), ResultConstants.dataListedMessage(Dayoff.class));
    }

    @PostMapping(value = "/add",consumes = "application/json")
    public Result add(@RequestBody DayoffDto dayoffDto){
        boolean success = dayoffFacade.add(dayoffDto);
        return wrapResultWithMessage(success, ResultConstants.addedMessage(Dayoff.class));
    }
    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam("id")  UUID id) {
        boolean success = dayoffFacade.deleteById(id);
        return wrapResultWithMessage(success, ResultConstants.deletedMessage(Dayoff.class));
    }
}
