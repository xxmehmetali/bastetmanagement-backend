package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.EmployeeDto;
import com.bastet.bastetmanagement.dtos.selectdtos.ApplicantSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ApplicantSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

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

    @Mapping(ignore = true, target = "id")
//    @Mapping(source = "applicantMeeting", target = "applicantMeeting", qualifiedByName = "applicantMeetingDtoToApplicantMeetingIdStatic")
    @Mapping(source = "CV", target = "CV", qualifiedByName = "cvDtoToCvIdStatic")
    Applicant applicantDtoToApplicant(ApplicantDto applicantDto);

    @Named("applicantDtoToApplicantOnlyId")
    default Applicant applicantDtoToApplicantOnlyId(ApplicantDto applicantDto){
        Applicant applicant = new Applicant();
        applicant.setId( applicantDto.getId() );
        return applicant;
    }

    @Named("applicantDtoToApplicantIdStatic")
    Applicant applicantDtoToApplicantIdStatic(ApplicantDto applicantDto);

    ApplicantSimplifiedDto applicantToApplicantSimplifiedDto(Applicant applicant);
    Applicant applicantSimplifiedDtoToApplicant(ApplicantSimplifiedDto applicantSimplifiedDto);

    //list versions
    List<Applicant> applicantDtoListToApplicantList(List<ApplicantDto> applicantDtos);
    List<ApplicantDto> applicantListToApplicantDtoList(List<Applicant> applicants);
    List<ApplicantSimplifiedDto> applicantListToApplicantSimplifiedDtoList(List<Applicant> applicants);

    @Mappings({
            @Mapping(target = "applicantFullName", expression = "java(applicant.getName() + ' ' + applicant.getSurname() + ' ' + '-' + ' ' + applicant.getPhoneNumber())")
    })
    ApplicantSelectElementDto applicantToApplicantSelectElementDto(Applicant applicant);

}
