package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.SocialActivitySimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.SocialActivity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                EmployeeMapper.class,
                ExpenseMapper.class,
                SocialActivityMapper.class
        }
)
public interface SocialActivityMapper {
    SocialActivityDto socialActivityToSocialActivityDto(SocialActivity socialActivity);
    SocialActivity socialActivityDtoToSocialActivity(SocialActivityDto socialActivityDto);
    SocialActivitySimplifiedDto socialActivityToSocialActivitySimplifiedDto(SocialActivity socialActivity);
    SocialActivity socialActivitySimplifiedDtoToSocialActivity(SocialActivitySimplifiedDto socialActivitySimplifiedDto);
    //list versions
    List<SocialActivityDto> socialActivityDtoListToSocialActivityList(List<SocialActivityDto> socialActivityDtos);
    List<SocialActivity> socialActivityListToSocialActivityDtoList(List<SocialActivity> socialActivities);
}