package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.daos.ContextDao;
import com.bastet.bastetmanagement.dtos.basedtos.BranchDto;
import com.bastet.bastetmanagement.dtos.basedtos.ContextDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ContextSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ContextSimplifiedDto;
import com.bastet.bastetmanagement.facades.context.ContextFacade;
import com.bastet.bastetmanagement.models.Context;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/context")
public class ContextController extends BaseController {
    @Resource
    private ContextFacade contextFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(contextFacade.findById(id), "");
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(contextFacade.findByIdSimplified(id), "");
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(contextFacade.findAllPaged(pageable), "");
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(contextFacade.findAllPagedSimplified(pageable), "");
    }

    @PostMapping(value = "/add",consumes = "application/json")
    public Result add(@RequestBody ContextDto contextDto){
        boolean success = contextFacade.add(contextDto);
        return wrapResultWithMessage(success, "selamke");
    }
    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<ContextSelectElementDto> contextSelectElementDtos = (List<ContextSelectElementDto>) contextFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(contextSelectElementDtos, "");
    }
}
