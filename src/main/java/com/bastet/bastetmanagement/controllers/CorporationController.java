package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.daos.CorporationDao;
import com.bastet.bastetmanagement.dtos.basedtos.CorporationDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CorporationSimplifiedDto;
import com.bastet.bastetmanagement.facades.corporation.CorporationFacade;
import com.bastet.bastetmanagement.models.Corporation;
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
    public Corporation findById(@PathVariable("id")UUID id){

//        return customModelMapper.map(corporationDao.findById(id).orElse(null), CorporationDto.class);
        return null;
    }

    @PostMapping("/addCorporation")
    public String addCorporation(@RequestBody Corporation corporation){
        return "ok";
    }

    @GetMapping("/simplified/findById/{id}")
    public CorporationSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
//        return corporationFacade.findByIdSimplified(id);
        return null;
    }
}
