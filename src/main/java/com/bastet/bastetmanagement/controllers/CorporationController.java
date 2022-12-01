package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.daos.CorporationDao;
import com.bastet.bastetmanagement.dtos.CorporationDto;
import com.bastet.bastetmanagement.models.Corporation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/corporation")
public class CorporationController {

    @Autowired
    private CorporationDao corporationDao;

    @Resource
    private ModelMapper modelMapper;

//    @Resource
//    private ModelMapperUtils<List<Corporation>, CorporationDto> modelMapperUtils;

    @GetMapping("/getAll")
    public List<CorporationDto> getAll(){
        List<CorporationDto> corporationDtoList = new ArrayList<>();
        corporationDao.findAll().stream()
                .forEach(c -> {
                    corporationDtoList.add(modelMapper.map(c, CorporationDto.class));
                });
        return corporationDtoList;
    }

//    @GetMapping("/getAll")
//    public List<CorporationDto> getAll(){
//        return modelMapperUtils.mapToList(corporationDao.findAll(), CorporationDto.class);
//    }

    @PostMapping("/addCorporation")
    public String addCorporation(@RequestBody Corporation corporation){
        corporationDao.save(corporation);
        return "ok";
    }
}
