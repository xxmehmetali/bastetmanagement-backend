package com.bastet.bastetmanagement.core.configurations.mapstruct;

import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityDto;
import com.bastet.bastetmanagement.models.SocialActivity;
import org.mapstruct.Mapper;

@Mapper
public interface SocialActivityMapper {
    SocialActivityDto socialActivityToSocialActivityDto(SocialActivity socialActivity);
    SocialActivity socialActivityDtoToSocialActivity(SocialActivityDto socialActivityDto);
}