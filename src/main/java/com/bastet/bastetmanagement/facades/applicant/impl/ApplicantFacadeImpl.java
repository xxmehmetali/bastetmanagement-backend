package com.bastet.bastetmanagement.facades.applicant.impl;


import com.bastet.bastetmanagement.core.enums.Gender;
import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ApplicantSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ApplicantSimplifiedDto;
import com.bastet.bastetmanagement.facades.applicant.ApplicantFacade;
import com.bastet.bastetmanagement.mappers.ApplicantMapper;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Model;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.services.applicant.ApplicantService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Log4j2
public class ApplicantFacadeImpl implements ApplicantFacade {
    @Resource
    private ApplicantService applicantService;

    @Resource
    private ApplicantMapper applicantMapper;

    @Override
    public ApplicantDto findById(UUID id) {
        Applicant applicant = applicantService.findById(id);
        return applicantMapper.applicantToApplicantDto(applicant);
    }

    @Override
    public ApplicantSimplifiedDto findByIdSimplified(UUID id) {
        Applicant applicant = applicantService.findById(id);
        return applicantMapper.applicantToApplicantSimplifiedDto(applicant);
    }

    @Override
    public Page<ApplicantDto> findAllPaged(Pageable pageable) {
        return applicantService.findAllPaged(pageable).map(applicant -> applicantMapper.applicantToApplicantDto(applicant));
    }

    @Override
    public Page<ApplicantSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return applicantService.findAllPaged(pageable).map(applicant -> applicantMapper.applicantToApplicantSimplifiedDto(applicant));
    }

    public List<ApplicantSelectElementDto> findAllForSelectElement() {
        List<Applicant> applicants = applicantService.findAll();
        return applicants.stream()
                .map(applicant -> {
                    return applicantMapper.applicantToApplicantSelectElementDto(applicant);
                })
                .collect(Collectors.toList());
    }

    @Override
    public boolean add(Dto dto) {
        Applicant applicant = applicantMapper.applicantDtoToApplicant((ApplicantDto) dto);
        return applicantService.add(applicant);
    }

    @Override
    public boolean deleteById(UUID id) {
        return applicantService.deleteById(id);
    }

    @Override
    public boolean update(Dto dto) {
        Applicant applicant = applicantMapper.applicantDtoToApplicantForUpdate((ApplicantDto) dto);
        boolean success = applicantService.add(applicant);
        return success;
    }
}
