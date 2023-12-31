package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.constants.ResultConstants;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.basedtos.OccupationDto;
import com.bastet.bastetmanagement.dtos.selectdtos.OccupationSelectElementDto;
import com.bastet.bastetmanagement.facades.occupation.OccupationFacade;
import com.bastet.bastetmanagement.models.Employee;
import com.bastet.bastetmanagement.models.Occupation;
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
    public Result findById(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(occupationFacade.findById(id), ResultConstants.foundMessage(Occupation.class));
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(occupationFacade.findByIdSimplified(id), ResultConstants.foundMessage(Occupation.class));
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(occupationFacade.findAllPaged(pageable), ResultConstants.dataListedMessage(Occupation.class));
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(occupationFacade.findAllPagedSimplified(pageable), ResultConstants.dataListedMessage(Occupation.class));
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public Result add(@RequestBody OccupationDto occupationDto) {
        boolean success = occupationFacade.add(occupationDto);
        return wrapResultWithMessage(success, ResultConstants.addedMessage(Occupation.class));
    }

    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<OccupationSelectElementDto> occupationSelectElementDtos = (List<OccupationSelectElementDto>) occupationFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(occupationSelectElementDtos, ResultConstants.dataListedMessageForSelection(Occupation.class));
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam("id") UUID id) {
        boolean success = occupationFacade.deleteById(id);
        return wrapResultWithMessage(success, ResultConstants.deletedMessage(MeetingController.class));
    }

    @PostMapping(value = "/update", consumes = "application/json")
    public Result update(@RequestBody OccupationDto occupationDto) {
        boolean success = occupationFacade.update(occupationDto);
        return wrapResultWithMessage(success, ResultConstants.updatedMessage(Occupation.class));
    }

}
