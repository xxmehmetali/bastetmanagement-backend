package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityDto;
import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityTypeDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.SocialActivitySelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.SocialActivityTypeSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.SocialActivityTypeSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.SocialActivity;
import com.bastet.bastetmanagement.models.SocialActivityType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface SocialActivityTypeMapper {
    SocialActivityTypeDto socialActivityTypeToSocialActivityTypeDto(SocialActivityType socialActivityType);

    @Mapping(ignore = true, target = "id")
    SocialActivityType socialActivityTypeDtoToSocialActivityType(SocialActivityTypeDto socialActivityTypeDto);

    @Named("socialActivityTypeDtoToSocialActivityTypeIdStatic")
    SocialActivityType socialActivityTypeDtoToSocialActivityTypeIdStatic(SocialActivityTypeDto socialActivityTypeDto);

    @Named("socialActivityTypeDtoToSocialActivityTypeForUpdate")
    SocialActivityType socialActivityTypeDtoToSocialActivityTypeForUpdate(SocialActivityTypeDto socialActivityTypeDto);

    @Named("socialActivityTypeDtoToSocialActivityTypeOnlyId")
    default SocialActivityType socialActivityTypeDtoToSocialActivityTypeOnlyId(SocialActivityTypeDto socialActivityTypeDto){
        SocialActivityType socialActivityType = new SocialActivityType();
        socialActivityType.setId( socialActivityTypeDto.getId() );
        return socialActivityType;
    }

    SocialActivityTypeSimplifiedDto socialActivityTypeToSocialActivityTypeSimplifiedDto(SocialActivityType socialActivityType);
    SocialActivityType socialActivityTypeSimplifiedDtoToSocialActivityType(SocialActivityTypeSimplifiedDto socialActivityTypeSimplifiedDto);
    //list versions
    List<SocialActivityType> socialActivityTypeDtoListToSocialActivityTypeList(List<SocialActivityTypeDto> socialActivityTypeDtos);
    List<SocialActivityTypeDto> socialActivityTypeListToSocialActivityTypeDtoList(List<SocialActivityType> socialActivityTypes);
    List<SocialActivityTypeSelectElementDto> SocialActivityTypeListToSocialActivityTypeSelectElementDtoList(List<SocialActivityType> socialActivityTypes);

}