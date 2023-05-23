package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.CvDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CvSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CvSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Cv;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
            ApplicantMapper.class
        }
)
public interface CvMapper {
    CvDto cvToCvDto(Cv cv);

    @Mapping(ignore = true, target = "id")
    Cv cvDtoToCv(CvDto cvDto);

    @Named("cvDtoToCvIdStatic")
    Cv cvDtoToCvIdStatic(CvDto cvDto);

    @Mapping(source = "applicant.CV.id", target = "id")
    @Mapping(target = "applicantFullName", expression = "java(applicant.getName() + ' ' + applicant.getSurname() + ' ' + '-' + ' ' + applicant.getPhoneNumber())")
    CvSelectElementDto cvAndApplicantToCvSelectElementDto( Applicant applicant);

    CvSimplifiedDto cvToCvSimplifiedDto(Cv cv);

    Cv cvSimplifiedDtoToCv(CvSimplifiedDto cvSimplifiedDto);

    //list versions
    List<Cv> cvDtoListToCvList(List<CvDto> cvDtos);

    List<CvDto> cvListToCvDtoList(List<Cv> cvs);

}
