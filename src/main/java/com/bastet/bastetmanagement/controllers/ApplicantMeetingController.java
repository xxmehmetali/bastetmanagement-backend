package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.core.constants.ResultConstants;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.daos.ApplicantMeetingDao;
import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantMeetingDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ApplicantMeetingSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.BranchSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ApplicantMeetingSimplifiedDto;
import com.bastet.bastetmanagement.facades.applicantmeeting.ApplicantMeetingFacade;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.ApplicantMeeting;
import com.bastet.bastetmanagement.models.Branch;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/applicantMeeting")
public class ApplicantMeetingController extends BaseController {
    @Resource
    private ApplicantMeetingFacade applicantMeetingFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage(applicantMeetingFacade.findById(id),  ResultConstants.foundMessage(ApplicantMeeting.class));
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage(applicantMeetingFacade.findByIdSimplified(id), ResultConstants.foundMessage(ApplicantMeeting.class));
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable){
        return wrapSuccessDataResultWithMessage(applicantMeetingFacade.findAllPaged(pageable), ResultConstants.dataListedMessage(ApplicantMeeting.class));
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable){
        return wrapSuccessDataResultWithMessage(applicantMeetingFacade.findAllPagedSimplified(pageable), ResultConstants.dataListedMessage(ApplicantMeeting.class));
    }

    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<ApplicantMeetingSelectElementDto> applicantMeetingSelectElementDtos = (List<ApplicantMeetingSelectElementDto>) applicantMeetingFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(applicantMeetingSelectElementDtos, ResultConstants.dataListedMessageForSelection(ApplicantMeeting.class));
    }

    @PostMapping(value = "/add",consumes = "application/json")
    public Result add(@RequestBody ApplicantMeetingDto applicantMeetingDto){
        boolean success = applicantMeetingFacade.add(applicantMeetingDto);
        return wrapResultWithMessage(success, ResultConstants.addedMessage(ApplicantMeeting.class));
    }
    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam("id")  UUID id) {
        boolean success = applicantMeetingFacade.deleteById(id);
        return wrapResultWithMessage(success, ResultConstants.deletedMessage(ApplicantMeeting.class));
    }

}
