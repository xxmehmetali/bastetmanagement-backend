package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.daos.ApplicantDao;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.facades.applicant.ApplicantFacade;
import com.bastet.bastetmanagement.models.Applicant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
    @Resource
    private ApplicantFacade applicantFacade;

    @Resource
    private CustomModelMapper customModelMapper;

    @Resource
    private ApplicantDao applicantDao;

    @GetMapping("/getAll")
    public List<ApplicantDto> getAll(){

        return null;
    }

    @GetMapping("/findById/{id}")
    public ApplicantDto findById(@PathVariable("id") UUID id){
        return applicantFacade.findById(id);
    }

}
