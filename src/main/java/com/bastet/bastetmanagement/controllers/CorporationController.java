package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
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
@RequestMapping("/corporation")
public class CorporationController {
    @Resource
    private CorporationFacade corporationFacade;
    @Resource
    private CorporationDao corporationDao;

    @Resource
    private CustomModelMapper customModelMapper;

    @GetMapping("/getAll")
    public List<CorporationDto> getAll(){
        List<Corporation> corporations = corporationDao.findAll();
        List<CorporationDto> corporationDtos = customModelMapper.mapToList(corporations, CorporationDto.class);
        return corporationDtos;
    }

    @GetMapping("/findById/{id}")
    public Corporation findById(@PathVariable("id")UUID id){

//        return customModelMapper.map(corporationDao.findById(id).orElse(null), CorporationDto.class);
        return corporationDao.findById(id).orElse(null);
    }

    @PostMapping("/addCorporation")
    public String addCorporation(@RequestBody Corporation corporation){
        corporationDao.save(corporation);
        return "ok";
    }

    @GetMapping("/simplified/findById/{id}")
    public CorporationSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
        return corporationFacade.findByIdSimplified(id);
    }
}
