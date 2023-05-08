package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.utilities.results.baseresults.Result;
import com.bastet.bastetmanagement.mappers.ApplicantMapper;
import com.bastet.bastetmanagement.daos.ApplicantDao;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ApplicantSimplifiedDto;
import com.bastet.bastetmanagement.facades.applicant.ApplicantFacade;
import org.springframework.data.domain.Pageable;
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
    public Result findById(@PathVariable("id") UUID id){
        ApplicantDto applicantDto = (ApplicantDto) applicantFacade.findById(id);
        return wrapSuccessDataResultWithMessage(applicantDto, "Applicant found.");
    }

    @GetMapping("/simplified/findById/{id}")
    public Result findByIdSimplified(@PathVariable("id") UUID id){
        return wrapSuccessDataResultWithMessage((ApplicantSimplifiedDto) applicantFacade.findByIdSimplified(id), "Applicant found.");
    }

    @GetMapping("/findAll")
    public Result findAllPaged(Pageable pageable) {
        return wrapDataResultWithMessage(applicantFacade.findAllPaged(pageable), true, "Data listed.");
    }

    @GetMapping("/simplified/findAll")
    public Result findAllPagedSimplified(Pageable pageable) {
        return wrapDataResultWithMessage(applicantFacade.findAllPagedSimplified(pageable), true, "Data listed.");
    }

    @GetMapping("")
    public Result findAllForSelectElement(){
       return null;
    }
}
