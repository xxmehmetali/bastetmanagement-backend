package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.daos.ContextDao;
import com.bastet.bastetmanagement.dtos.basedtos.ContextDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ContextSimplifiedDto;
import com.bastet.bastetmanagement.facades.context.ContextFacade;
import com.bastet.bastetmanagement.models.Context;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/context")
public class ContextController extends BaseController {
    @Resource
    private ContextFacade contextFacade;

    public ContextController(final ContextDao contextDao){
        this.contextDao = contextDao;
    }

    @GetMapping("/findById/{id}")
    public ContextDto findById(@PathVariable("id")UUID id){
        return null;
    }

    @GetMapping("/simplified/findById/{id}")
    public ContextSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
        return (ContextSimplifiedDto) contextFacade.findByIdSimplified(id);
    }
}
