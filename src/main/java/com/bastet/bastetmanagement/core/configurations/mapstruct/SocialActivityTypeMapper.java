package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityTypeDto;
import com.bastet.bastetmanagement.models.SocialActivityType;
import org.mapstruct.Mapper;

@Mapper
public interface SocialActivityTypeMapper {
    SocialActivityTypeDto socialActivityTypeToSocialActivityTypeDto(SocialActivityType socialActivityType);
    SocialActivityType socialActivityTypeDtoToSocialActivityType(SocialActivityTypeDto socialActivityTypeDto);
}