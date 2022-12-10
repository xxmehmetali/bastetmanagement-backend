package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.daos.DayOffDao;
import com.bastet.bastetmanagement.dtos.basedtos.DayoffDto;
import com.bastet.bastetmanagement.models.Dayoff;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/dayoff")
public class DayoffController {

    @Resource
    private DayOffDao dayOffDao;

    @Resource
    private CustomModelMapper customModelMapper;

    @GetMapping("/findById/{id}")
    public DayoffDto findById(@PathVariable("id")UUID id){
        return customModelMapper.map(dayOffDao.findById(id).orElse(null), DayoffDto.class);
    }
}
