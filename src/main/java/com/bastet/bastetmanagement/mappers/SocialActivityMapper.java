package com.bastet.bastetmanagement.mappers;

import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityDto;
import com.bastet.bastetmanagement.dtos.selectdtos.SocialActivitySelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.SocialActivitySimplifiedDto;
import com.bastet.bastetmanagement.models.SocialActivity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;
import java.util.Objects;

@Mapper(
        componentModel = "spring",
        uses = {
                EmployeeMapper.class,
                ExpenseMapper.class,
                SocialActivityTypeMapper.class
        }
)
public interface SocialActivityMapper {
    SocialActivityDto socialActivityToSocialActivityDto(SocialActivity socialActivity);

    @Mapping(ignore = true, target = "id")
    @Mapping(source = "expense", target = "expense", qualifiedByName = "expenseDtoToExpenseIdStatic")
//    @Mapping(source = "socialActivityType", target = "socialActivityType", qualifiedByName = "socialActivityTypeDtoToSocialActivityTypeIdStatic")
    SocialActivity socialActivityDtoToSocialActivity(SocialActivityDto socialActivityDto);

    @Mappings({
            @Mapping(source = "expense", target = "expense", qualifiedByName = "expenseDtoToExpenseOnlyId"),
            @Mapping(source = "socialActivityType", target = "socialActivityType", qualifiedByName = "socialActivityTypeDtoToSocialActivityTypeOnlyId"),
            @Mapping(source = "employees", target = "employees", qualifiedByName = "employeeDtoListToEmployeeListOnlyId")
    })
    @Named("socialActivityDtoToSocialActivityForUpdate")
    SocialActivity socialActivityDtoToSocialActivityForUpdate(SocialActivityDto socialActivityDto);

    @Named("socialActivityDtoToSocialActivityOnlyId")
    default SocialActivity socialActivityDtoToSocialActivityOnlyId(SocialActivityDto socialActivityDto){
        if (Objects.isNull(socialActivityDto.getId())) return  null;

        SocialActivity socialActivity = new SocialActivity();
        socialActivity.setId( socialActivityDto.getId() );
        return socialActivity;
    }

//    @Named("socialActivityDtoToSocialActivityIdStatic")
//    SocialActivity socialActivityDtoToSocialActivityIdStatic(SocialActivityDto socialActivityDto);

    SocialActivitySimplifiedDto socialActivityToSocialActivitySimplifiedDto(SocialActivity socialActivity);
    SocialActivity socialActivitySimplifiedDtoToSocialActivity(SocialActivitySimplifiedDto socialActivitySimplifiedDto);
    //list versions
    List<SocialActivityDto> socialActivityDtoListToSocialActivityList(List<SocialActivityDto> socialActivityDtos);
    List<SocialActivity> socialActivityListToSocialActivityDtoList(List<SocialActivity> socialActivities);
    List<SocialActivitySelectElementDto> socialActivityListToSocialActivitySelectElementDtoList(List<SocialActivity> socialActivities);

}