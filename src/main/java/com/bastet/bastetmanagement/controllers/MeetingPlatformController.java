package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.constants.ResultConstants;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.daos.MeetingPlatformDao;
import com.bastet.bastetmanagement.dtos.basedtos.MeetingDto;
import com.bastet.bastetmanagement.dtos.basedtos.MeetingPlatformDto;
import com.bastet.bastetmanagement.dtos.selectdtos.MeetingPlatformSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingPlatformSimplifiedDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingSimplifiedDto;
import com.bastet.bastetmanagement.facades.meetingplatform.MeetingPlatformFacade;
import com.bastet.bastetmanagement.models.Meeting;
import com.bastet.bastetmanagement.models.MeetingPlatform;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/meetingPlatform")
public class MeetingPlatformController extends BaseController {
    @Resource
    private MeetingPlatformFacade meetingPlatformFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage(meetingPlatformFacade.findById(id),  ResultConstants.foundMessage(MeetingPlatform.class));
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage(meetingPlatformFacade.findByIdSimplified(id),  ResultConstants.foundMessage(MeetingPlatform.class));
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable){
        return wrapSuccessDataResultWithMessage(meetingPlatformFacade.findAllPaged(pageable),  ResultConstants.dataListedMessage(MeetingPlatform.class));
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable){
        return wrapSuccessDataResultWithMessage(meetingPlatformFacade.findAllPagedSimplified(pageable),  ResultConstants.dataListedMessage(MeetingPlatform.class));
    }

    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<MeetingPlatformSelectElementDto> meetingPlatformSelectElementDtos = (List<MeetingPlatformSelectElementDto>) meetingPlatformFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(meetingPlatformSelectElementDtos,  ResultConstants.foundMessage(MeetingPlatform.class));
    }

    @PostMapping(value = "/add",consumes = "application/json")
    public Result add(@RequestBody MeetingPlatformDto meetingPlatformDto){
        boolean success = meetingPlatformFacade.add(meetingPlatformDto);
        return wrapResultWithMessage(success, ResultConstants.addedMessage(MeetingPlatform.class));
    }
    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam("id")  UUID id) {
        boolean success = meetingPlatformFacade.deleteById(id);
        return wrapResultWithMessage(success, ResultConstants.deletedMessage(MeetingPlatform.class));
    }
}
