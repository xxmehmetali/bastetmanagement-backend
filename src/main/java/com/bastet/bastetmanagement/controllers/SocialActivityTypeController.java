package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.daos.ApplicantDao;
import com.bastet.bastetmanagement.daos.SocialActivityDao;
import com.bastet.bastetmanagement.daos.SocialActivityTypeDao;
import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityTypeDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.SocialActivityTypeSimplifiedDto;
import com.bastet.bastetmanagement.facades.socialactivitytype.SocialActivityTypeFacade;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Project;
import com.bastet.bastetmanagement.models.SocialActivity;
import com.bastet.bastetmanagement.models.SocialActivityType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestControllerAdvice
@RequestMapping("/socialActivityType")
public class SocialActivityTypeController {

    @Resource
    private SocialActivityTypeDao socialActivityTypeDao;

    @Resource
    private SocialActivityTypeFacade socialActivityTypeFacade;

    @GetMapping("/simplified/findById/{id}")
    public SocialActivityTypeSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
        return socialActivityTypeFacade.findByIdSimplified(id);
    }
    @GetMapping("/getAll")
    public List<SocialActivityType> getAll(){
        return socialActivityTypeDao.findAll();
    }

    @GetMapping("/findById/{id}")
    public SocialActivityTypeDto findById(@PathVariable("id") UUID id){
//        SocialActivityType activityType =  socialActivityTypeDao.findById(id).get();
//        return activityType;
        return customModelMapper.map(socialActivityTypeDao.findById(id).orElse(null), SocialActivityTypeDto.class);
    }
}

