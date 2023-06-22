package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.constants.ResultConstants;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.dtos.basedtos.MeetingDto;
import com.bastet.bastetmanagement.facades.meeting.MeetingFacade;
import com.bastet.bastetmanagement.models.Meeting;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/meeting")
public class MeetingController extends BaseController {
    @Resource
    private MeetingFacade meetingFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(meetingFacade.findById(id), ResultConstants.foundMessage(Meeting.class));
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage(meetingFacade.findByIdSimplified(id), ResultConstants.foundMessage(Meeting.class));
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(meetingFacade.findAllPaged(pageable), ResultConstants.dataListedMessage(Meeting.class));
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable) {
        return wrapSuccessDataResultWithMessage(meetingFacade.findAllPagedSimplified(pageable), ResultConstants.dataListedMessage(Meeting.class));
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public Result add(@RequestBody MeetingDto meetingDto) {
        boolean success = meetingFacade.add(meetingDto);
        return wrapResultWithMessage(success, ResultConstants.addedMessage(Meeting.class));
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam("id") UUID id) {
        boolean success = meetingFacade.deleteById(id);
        return wrapResultWithMessage(success, ResultConstants.deletedMessage(Meeting.class));
    }

    @PostMapping(value = "/update", consumes = "application/json")
    public Result update(@RequestBody MeetingDto meetingDto) {
        boolean success = meetingFacade.update(meetingDto);
        return wrapResultWithMessage(success, ResultConstants.updatedMessage(Meeting.class));
    }

}
