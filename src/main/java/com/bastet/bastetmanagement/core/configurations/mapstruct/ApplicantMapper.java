package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.models.Applicant;
import org.mapstruct.Mapper;

@Mapper
public interface ApplicantMapper {
    ApplicantDto applicantToApplicantDto(Applicant applicant);
    Applicant applicantDtoToApplicant(ApplicantDto applicantDto);
}
