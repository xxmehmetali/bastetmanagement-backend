package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.CvDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CvSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Cv;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CvMapper {
    CvDto cvToCvDto(Cv cv);
    Cv cvDtoToCv(CvDto cvDto);
    CvSimplifiedDto cvToCvSimplifiedDto(Cv cv);
    Cv cvSimplifiedDtoToCv(CvSimplifiedDto cvSimplifiedDto);
    //list versions
    List<Cv> cvDtoListToCvList(List<CvDto> cvDtos);
    List<CvDto> cvListToCvDtoList(List<Cv> cvs);

}
