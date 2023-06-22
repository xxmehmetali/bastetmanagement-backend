package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.constants.ResultConstants;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityDto;
import com.bastet.bastetmanagement.dtos.selectdtos.SocialActivitySelectElementDto;
import com.bastet.bastetmanagement.facades.socialactivity.SocialActivityFacade;
import com.bastet.bastetmanagement.models.Employee;
import com.bastet.bastetmanagement.models.SocialActivity;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/socialActivity")
public class SocialActivityController extends BaseController {
    @Resource
    private SocialActivityFacade socialActivityFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(socialActivityFacade.findById(id), ResultConstants.foundMessage(SocialActivity.class));
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(socialActivityFacade.findByIdSimplified(id), ResultConstants.foundMessage(SocialActivity.class));
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(socialActivityFacade.findAllPaged(pageable), ResultConstants.dataListedMessage(SocialActivity.class));
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(socialActivityFacade.findAllPagedSimplified(pageable), ResultConstants.dataListedMessage(SocialActivity.class));
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public Result add(@RequestBody SocialActivityDto socialActivityDto) {
        boolean success = socialActivityFacade.add(socialActivityDto);
        return wrapResultWithMessage(success, ResultConstants.addedMessage(SocialActivity.class));
    }

    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<SocialActivitySelectElementDto> socialActivitySelectElementDtos = (List<SocialActivitySelectElementDto>) socialActivityFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(socialActivitySelectElementDtos, ResultConstants.dataListedMessageForSelection(SocialActivity.class));
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam("id") UUID id) {
        boolean success = socialActivityFacade.deleteById(id);
        return wrapResultWithMessage(success, ResultConstants.deletedMessage(SocialActivity.class));
    }

    @PostMapping(value = "/update", consumes = "application/json")
    public Result update(@RequestBody SocialActivityDto socialActivityDto) {
        boolean success = socialActivityFacade.update(socialActivityDto);
        return wrapResultWithMessage(success, ResultConstants.updatedMessage(SocialActivity.class));
    }

}
