package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ApplicantSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ApplicantSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Corporation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                CvMapper.class,
                ApplicantMeetingMapper.class
        }
)
public interface ApplicantMapper {
    //
    ApplicantDto applicantToApplicantDto(Applicant applicant);
    Applicant applicantDtoToApplicant(ApplicantDto applicantDto);
    ApplicantSimplifiedDto applicantToApplicantSimplifiedDto(Applicant applicant);
    Applicant applicantSimplifiedDtoToApplicant(ApplicantSimplifiedDto applicantSimplifiedDto);

    //list versions
    List<Applicant> applicantDtoListToApplicantList(List<ApplicantDto> applicantDtos);
    List<ApplicantDto> applicantListToApplicantDtoList(List<Applicant> applicants);
    List<ApplicantSimplifiedDto> applicantListToApplicantSimplifiedDtoList(List<Applicant> applicants);
    List<ApplicantSelectElementDto> applicantListToApplicantSelectElementDtoList(List<Applicant> applicants);

}
