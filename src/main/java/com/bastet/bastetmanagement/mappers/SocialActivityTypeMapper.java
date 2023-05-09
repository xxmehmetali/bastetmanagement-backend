package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityTypeDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.SocialActivitySelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.SocialActivityTypeSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.SocialActivityTypeSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.SocialActivityType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SocialActivityTypeMapper {
    SocialActivityTypeDto socialActivityTypeToSocialActivityTypeDto(SocialActivityType socialActivityType);
    SocialActivityType socialActivityTypeDtoToSocialActivityType(SocialActivityTypeDto socialActivityTypeDto);
    SocialActivityTypeSimplifiedDto socialActivityTypeToSocialActivityTypeSimplifiedDto(SocialActivityType socialActivityType);
    SocialActivityType socialActivityTypeSimplifiedDtoToSocialActivityType(SocialActivityTypeSimplifiedDto socialActivityTypeSimplifiedDto);
    //list versions
    List<SocialActivityType> socialActivityTypeDtoListToSocialActivityTypeList(List<SocialActivityTypeDto> socialActivityTypeDtos);
    List<SocialActivityTypeDto> socialActivityTypeListToSocialActivityTypeDtoList(List<SocialActivityType> socialActivityTypes);
    List<SocialActivityTypeSelectElementDto> SocialActivityTypeListToSocialActivityTypeSelectElementDtoList(List<SocialActivityType> socialActivityTypes);

}