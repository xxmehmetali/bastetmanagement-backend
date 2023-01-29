package com.bastet.bastetmanagement.facades.applicant.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ApplicantSimplifiedDto;
import com.bastet.bastetmanagement.facades.applicant.ApplicantFacade;
import com.bastet.bastetmanagement.services.applicant.ApplicantService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
@Log4j2
public class ApplicantFacadeImpl implements ApplicantFacade {


    @Resource
    private ApplicantService applicantService;

    @Override
    public ApplicantDto findById(UUID id) {
        return null;
    }

    @Override
    public ApplicantSimplifiedDto findByIdSimplified(UUID id) {
        return new ApplicantSimplifiedDto();
    }
}
