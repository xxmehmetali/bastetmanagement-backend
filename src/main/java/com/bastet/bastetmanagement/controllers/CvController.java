package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.utilities.results.dataresults.DataResult;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CvSimplifiedDto;
import com.bastet.bastetmanagement.facades.cv.CvFacade;
import com.bastet.bastetmanagement.models.Cv;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cv")
public class CvController {
    @Resource
    private CvFacade cvFacade;

    @GetMapping("/findAll")
    public DataResult<List<Cv>> findAll(){
        return cvFacade.findAll();
    }

    @GetMapping("/findById/{id}")
    public Cv findById(@PathVariable(name = "id")UUID id){
        return cvFacade.findById(id);
    }

    @GetMapping("/simplified/findById/{id}")
    public CvSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
        return cvFacade.findByIdSimplified(id);
    }
}
