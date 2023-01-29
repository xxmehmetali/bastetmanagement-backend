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

    @Resource
    private ApplicantMapper applicantMapper;

    @GetMapping("/getAll")
    public List<ApplicantDto> getAll(){
        return null;
    }

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") UUID id){
//        return applicantFacade.findById(id);
        Result r=wrapErrorDataResultWithMessage("as","asd");
        return r;
    }

    @GetMapping("/simplified/findById/{id}")
    @ResponseBody
    public Result findByIdSimplified(@PathVariable("id") UUID id){
        return wrapDataResult((ApplicantSimplifiedDto) applicantFacade.findByIdSimplified(id), true);
    }

    @GetMapping("/simplified/paged")
    @ResponseBody
    public Result findApplicantsPaged(Pageable pageable) {
        return wrapDataResultWithMessage(applicantFacade.findAllPaged(pageable), true, "Data listed.");
    }

}
