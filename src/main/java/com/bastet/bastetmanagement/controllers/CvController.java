package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.utilities.results.dataresults.DataResult;
import com.bastet.bastetmanagement.dtos.basedtos.CvDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CvSimplifiedDto;
import com.bastet.bastetmanagement.facades.cv.CvFacade;
import com.bastet.bastetmanagement.models.Cv;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cv")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CvController {
    @Resource
    private CvFacade cvFacade;

    @GetMapping("/findAll")
    @PreAuthorize("hasRole('USER')")
    public DataResult<List<Cv>> findAll(){
        return cvFacade.findAll();
    }

    @GetMapping("/findById/{id}")
    public CvDto findById(@PathVariable(name = "id")UUID id){
        return cvFacade.findById(id);
    }

    @GetMapping("/simplified/findById/{id}")
    public CvSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
        return cvFacade.findByIdSimplified(id);
    }
}
