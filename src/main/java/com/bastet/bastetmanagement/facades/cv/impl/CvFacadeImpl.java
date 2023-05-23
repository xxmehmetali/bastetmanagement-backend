package com.bastet.bastetmanagement.facades.cv.impl;

import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.CurrencyDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CvSelectElementDto;
import com.bastet.bastetmanagement.mappers.CvMapper;

import com.bastet.bastetmanagement.core.utilities.results.dataresults.DataResult;
import com.bastet.bastetmanagement.core.utilities.results.dataresults.ErrorDataResult;
import com.bastet.bastetmanagement.core.utilities.results.dataresults.SuccessDataResult;
import com.bastet.bastetmanagement.dtos.basedtos.CvDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CvSimplifiedDto;
import com.bastet.bastetmanagement.facades.cv.CvFacade;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Currency;
import com.bastet.bastetmanagement.models.Cv;
import com.bastet.bastetmanagement.services.applicant.ApplicantService;
import com.bastet.bastetmanagement.services.cv.CvService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CvFacadeImpl implements CvFacade {
    @Resource
    CvService cvService;

    @Resource
    ApplicantService applicantService;

    @Resource
    private CvMapper cvMapper;

    @Override
    public CvDto findById(UUID id) {
        return cvMapper.cvToCvDto(cvService.findById(id));
    }

    @Override
    public CvSimplifiedDto findByIdSimplified(UUID id) {
        return cvMapper.cvToCvSimplifiedDto(cvService.findById(id));
    }

    @Override
    public Page<CvDto> findAllPaged(Pageable pageable) {
        return cvService.findAllPaged(pageable).map(cv -> cvMapper.cvToCvDto(cv));
    }

    @Override
    public Page<CvSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return cvService.findAllPaged(pageable).map(cv -> cvMapper.cvToCvSimplifiedDto(cv));
    }

    @Override
    public List<CvSelectElementDto> findAllForSelectElement() {
        List<Applicant> applicants = applicantService.findAll();
        return applicants.stream()
                .map(applicant -> {
                    return cvMapper.cvAndApplicantToCvSelectElementDto( applicant);
                })
                .collect(Collectors.toList());
    }

    @Override
    public boolean add(Dto dto) {
        Cv cv = cvMapper.cvDtoToCv((CvDto) dto);
        boolean success = cvService.add(cv);
        return success;
    }
    @Override
    public boolean deleteById(UUID id) {
        return cvService.deleteById(id);
    }
}
