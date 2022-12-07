package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.daos.ContextDao;
import com.bastet.bastetmanagement.models.Context;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/context")
public class ContextController {

    private final ContextDao contextDao;
    public ContextController(final ContextDao contextDao){
        this.contextDao = contextDao;
    }

    @GetMapping("/findById/{id}")
    public Context findById(@PathVariable("id")UUID id){
        return contextDao.findById(id).orElse(null);
    }
}
