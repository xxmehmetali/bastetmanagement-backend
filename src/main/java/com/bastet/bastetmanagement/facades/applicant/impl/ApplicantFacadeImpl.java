package com.bastet.bastetmanagement.facades.applicant.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ApplicantSimplifiedDto;
import com.bastet.bastetmanagement.facades.applicant.ApplicantFacade;
import com.bastet.bastetmanagement.mappers.ApplicantMapper;
import com.bastet.bastetmanagement.services.applicant.ApplicantService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
@Log4j2
public class ApplicantFacadeImpl implements ApplicantFacade {
    @Resource
    private ApplicantService applicantService;

    @Resource
    private ApplicantMapper applicantMapper;

    @Override
    public ApplicantDto findById(UUID id) {
        return new ApplicantDto();
    }

    @Override
    public ApplicantSimplifiedDto findByIdSimplified(UUID id) {
//        return applicantMapper.applicantToApplicantSimplifiedDto(applicantService.findById(id));
        return new ApplicantSimplifiedDto();

    }

    @Override
    public Page<ApplicantDto> findAllPaged(Pageable pageable) {
        Page pageImpl = applicantService.findApplicantsPaged(pageable);
        List<ApplicantDto> applicantDtoss = applicantMapper.applicantListToApplicantDtoList(pageImpl.getContent());
        return new PageImpl<>(applicantDtoss, pageable, pageImpl.getTotalPages());
    }

    @Override
    public Page<ApplicantSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return null;
    }
}
