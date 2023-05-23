package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityDto;
import com.bastet.bastetmanagement.dtos.selectdtos.CorporationSelectElementDto;
import com.bastet.bastetmanagement.dtos.selectdtos.SocialActivitySelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.SocialActivitySimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.SocialActivity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

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

    @Mapping(ignore = true, target = "id")
    @Mapping(source = "expense", target = "expense", qualifiedByName = "expenseDtoToExpenseIdStatic")
//    @Mapping(source = "socialActivityType", target = "socialActivityType", qualifiedByName = "socialActivityTypeDtoToSocialActivityTypeIdStatic")
    SocialActivity socialActivityDtoToSocialActivity(SocialActivityDto socialActivityDto);

    @Named("socialActivityDtoToSocialActivityIdStatic")
    SocialActivity socialActivityDtoToSocialActivityIdStatic(SocialActivityDto socialActivityDto);

    SocialActivitySimplifiedDto socialActivityToSocialActivitySimplifiedDto(SocialActivity socialActivity);
    SocialActivity socialActivitySimplifiedDtoToSocialActivity(SocialActivitySimplifiedDto socialActivitySimplifiedDto);
    //list versions
    List<SocialActivityDto> socialActivityDtoListToSocialActivityList(List<SocialActivityDto> socialActivityDtos);
    List<SocialActivity> socialActivityListToSocialActivityDtoList(List<SocialActivity> socialActivities);
    List<SocialActivitySelectElementDto> socialActivityListToSocialActivitySelectElementDtoList(List<SocialActivity> socialActivities);

}