package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.constants.ResultConstants;
import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ApplicantSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ApplicantSimplifiedDto;
import com.bastet.bastetmanagement.facades.applicant.ApplicantFacade;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/applicant")
public class ApplicantController extends BaseController {
    @Resource
    private ApplicantFacade applicantFacade;

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") UUID id) {
        ApplicantDto applicantDto = (ApplicantDto) applicantFacade.findById(id);
        return wrapSuccessDataResultWithMessage(applicantDto, ResultConstants.foundMessage(Applicant.class));
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id) {
        return wrapSuccessDataResultWithMessage((ApplicantSimplifiedDto) applicantFacade.findByIdSimplified(id), ResultConstants.foundMessage(Applicant.class));
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable) {
        return wrapDataResultWithMessage(applicantFacade.findAllPaged(pageable), true, ResultConstants.dataListedMessage(Applicant.class));
    }

    @GetMapping("/simplified/findAll")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Result findAllPagedSimplified(Pageable pageable) {
        return wrapDataResultWithMessage(applicantFacade.findAllPagedSimplified(pageable), true, ResultConstants.dataListedMessage(Applicant.class));
    }

    @GetMapping(value = "/selectElement/findAll")
    public Result findAllForSelectElement() {
        List<ApplicantSelectElementDto> applicantSelectElementDtos = (List<ApplicantSelectElementDto>) applicantFacade.findAllForSelectElement();
        return wrapSuccessDataResultWithMessage(applicantSelectElementDtos, ResultConstants.dataListedMessageForSelection(Applicant.class));
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public Result add(@RequestBody ApplicantDto applicantDto) {
        boolean success = applicantFacade.add(applicantDto);
        return wrapResultWithMessage(success, ResultConstants.addedMessage(Applicant.class));
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam("id") UUID id) {
        boolean success = applicantFacade.deleteById(id);
        return wrapResultWithMessage(success, ResultConstants.deletedMessage(Applicant.class));
    }

    @PostMapping(value = "/update", consumes = "application/json")
    public Result update(@RequestBody ApplicantDto applicantDto) {
        boolean success = applicantFacade.update(applicantDto);
        return wrapResultWithMessage(success, ResultConstants.updatedMessage(Employee.class));
    }

}

