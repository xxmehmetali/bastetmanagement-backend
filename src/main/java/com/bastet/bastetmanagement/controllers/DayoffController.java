package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.daos.DayOffDao;
import com.bastet.bastetmanagement.dtos.basedtos.DayoffDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.DayoffSimplifiedDto;
import com.bastet.bastetmanagement.facades.dayoff.DayoffFacade;
import com.bastet.bastetmanagement.models.Dayoff;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/dayoff")
public class DayoffController extends BaseController {
    @Resource
    private DayoffFacade dayoffFacade;


    @GetMapping("/findById/{id}")
    public DayoffDto findById(@PathVariable("id")UUID id){
//        return customModelMapper.map(dayOffDao.findById(id).orElse(null), DayoffDto.class);
        return null;
    }

    @GetMapping("/simplified/findById/{id}")
    public DayoffSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
        return dayoffFacade.findByIdSimplified(id);
    }
}
