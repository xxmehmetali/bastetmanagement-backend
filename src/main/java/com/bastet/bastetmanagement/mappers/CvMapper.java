package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.CvDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.CvSimplifiedDto;
import com.bastet.bastetmanagement.models.Cv;
import org.mapstruct.Mapper;

@Mapper
public interface CvMapper {
    CvDto cvToCvDto(Cv cv);
    Cv cvDtoToCv(CvDto cvDto);
    CvSimplifiedDto cvToCvSimplifiedDto(Cv cv);
    Cv cvSimplifiedDtoToCv(CvSimplifiedDto cvSimplifiedDto);
}
