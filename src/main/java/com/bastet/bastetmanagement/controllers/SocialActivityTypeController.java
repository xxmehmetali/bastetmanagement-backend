package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.constants.ResultConstants;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.daos.ApplicantDao;
import com.bastet.bastetmanagement.daos.SocialActivityDao;
import com.bastet.bastetmanagement.daos.SocialActivityTypeDao;
import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityDto;
import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityTypeDto;
import com.bastet.bastetmanagement.dtos.selectdtos.SocialActivitySelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.SocialActivityTypeSimplifiedDto;
import com.bastet.bastetmanagement.facades.socialactivitytype.SocialActivityTypeFacade;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Project;
import com.bastet.bastetmanagement.models.SocialActivity;
import com.bastet.bastetmanagement.models.SocialActivityType;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestControllerAdvice
@RequestMapping("/api/v1/socialActivityType")
public class SocialActivityTypeController extends BaseController {
    @Resource
    private SocialActivityTypeFacade socialActivityTypeFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage(socialActivityTypeFacade.findById(id),  ResultConstants.foundMessage(SocialActivityType.class));
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage(socialActivityTypeFacade.findByIdSimplified(id),  ResultConstants.foundMessage(SocialActivityType.class));
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable){
        return wrapSuccessDataResultWithMessage(socialActivityTypeFacade.findAllPaged(pageable),  ResultConstants.dataListedMessage(SocialActivityType.class));
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable){
        return wrapSuccessDataResultWithMessage(socialActivityTypeFacade.findAllPagedSimplified(pageable),  ResultConstants.dataListedMessage(SocialActivityType.class));
    }

    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<SocialActivitySelectElementDto> socialActivitySelectElementDtos = (List<SocialActivitySelectElementDto>) socialActivityTypeFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(socialActivitySelectElementDtos,  ResultConstants.dataListedMessageForSelection(SocialActivityType.class));
    }
    @PostMapping(value = "/add",consumes = "application/json")
    public Result add(@RequestBody SocialActivityTypeDto socialActivityDto){
        boolean success = socialActivityTypeFacade.add(socialActivityDto);
        return wrapResultWithMessage(success, ResultConstants.addedMessage(SocialActivityType.class));
    }
    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam("id")  UUID id) {
        boolean success = socialActivityTypeFacade.deleteById(id);
        return wrapResultWithMessage(success, ResultConstants.deletedMessage(SocialActivityType.class));
    }
}

