package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.daos.OccupationDao;
import com.bastet.bastetmanagement.daos.ProjectDao;
import com.bastet.bastetmanagement.dtos.basedtos.OccupationDto;
import com.bastet.bastetmanagement.models.Occupation;
import com.bastet.bastetmanagement.models.Project;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/occupation")
public class OccupationController {

    @Resource
    private OccupationDao occupationDao;
    @Resource
    private CustomModelMapper customModelMapper;
    @GetMapping("/getAll")
    public List<Occupation> getAll(){
        return occupationDao.findAll();
    }

    @GetMapping("/findById/{id}")
    public OccupationDto findById(@PathVariable("id") UUID id){
        return customModelMapper.map(occupationDao.findById(id).orElse(null), OccupationDto.class);
    }
}
