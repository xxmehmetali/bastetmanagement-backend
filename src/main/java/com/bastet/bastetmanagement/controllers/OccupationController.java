package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.daos.OccupationDao;
import com.bastet.bastetmanagement.daos.ProjectDao;
import com.bastet.bastetmanagement.dtos.basedtos.MeetingPlatformDto;
import com.bastet.bastetmanagement.dtos.basedtos.OccupationDto;
import com.bastet.bastetmanagement.dtos.selectdtos.OccupationSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.OccupationSimplifiedDto;
import com.bastet.bastetmanagement.facades.occupation.OccupationFacade;
import com.bastet.bastetmanagement.models.Occupation;
import com.bastet.bastetmanagement.models.Project;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/occupation")
public class OccupationController extends BaseController {

    @Resource
    private OccupationFacade occupationFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage(occupationFacade.findById(id), "");
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage(occupationFacade.findByIdSimplified(id), "");
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable){
        return wrapSuccessDataResultWithMessage(occupationFacade.findAllPaged(pageable), "");
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable){
        return wrapSuccessDataResultWithMessage(occupationFacade.findAllPagedSimplified(pageable), "");
    }

    @PostMapping(value = "/add",consumes = "application/json")
    public Result add(@RequestBody OccupationDto occupationDto){
        boolean success = occupationFacade.add(occupationDto);
        return wrapResultWithMessage(success, "selamke");
    }
    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<OccupationSelectElementDto> occupationSelectElementDtos = (List<OccupationSelectElementDto>) occupationFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(occupationSelectElementDtos, "");
    }
}
