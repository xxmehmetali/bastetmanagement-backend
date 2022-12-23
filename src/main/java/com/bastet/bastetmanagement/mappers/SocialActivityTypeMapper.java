package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityTypeDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.SocialActivityTypeSimplifiedDto;
import com.bastet.bastetmanagement.models.SocialActivityType;
import org.mapstruct.Mapper;

@Mapper
public interface SocialActivityTypeMapper {
    SocialActivityTypeDto socialActivityTypeToSocialActivityTypeDto(SocialActivityType socialActivityType);
    SocialActivityType socialActivityTypeDtoToSocialActivityType(SocialActivityTypeDto socialActivityTypeDto);
    SocialActivityTypeSimplifiedDto socialActivityTypeToSocialActivityTypeSimplifiedDto(SocialActivityType socialActivityType);
    SocialActivityType socialActivityTypeSimplifiedDtoToSocialActivityType(SocialActivityTypeSimplifiedDto socialActivityTypeSimplifiedDto);

}