package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.daos.ContextDao;
import com.bastet.bastetmanagement.dtos.basedtos.ContextDto;
import com.bastet.bastetmanagement.models.Context;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/context")
public class ContextController {

    @Resource
    private ContextDao contextDao;

    @Resource
    private CustomModelMapper customModelMapper;

    public ContextController(final ContextDao contextDao){
        this.contextDao = contextDao;
    }

    @GetMapping("/findById/{id}")
    public ContextDto findById(@PathVariable("id")UUID id){
        return customModelMapper.map(contextDao.findById(id).orElseThrow(() -> new ModelNotFoundException(Context.class.getName())), ContextDto.class);
//        return contextDao.findById(id).orElse(null);
    }
}
