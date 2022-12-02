package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.daos.CorporationDao;
import com.bastet.bastetmanagement.dtos.basedtos.CorporationDto;
import com.bastet.bastetmanagement.models.Corporation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/corporation")
public class CorporationController {

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

    @PostMapping("/addCorporation")
    public String addCorporation(@RequestBody Corporation corporation){
        corporationDao.save(corporation);
        return "ok";
    }
}
