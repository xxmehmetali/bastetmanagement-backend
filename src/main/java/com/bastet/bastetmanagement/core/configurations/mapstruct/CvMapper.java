package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.CvDto;
import com.bastet.bastetmanagement.models.Cv;
import org.mapstruct.Mapper;

@Mapper
public interface CvMapper {
    CvDto cvToCvDto(Cv cv);
    Cv cvDtoToCv(CvDto cvDto);
}
