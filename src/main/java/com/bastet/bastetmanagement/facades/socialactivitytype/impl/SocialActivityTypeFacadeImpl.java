package com.bastet.bastetmanagement.facades.socialactivitytype.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityTypeDto;
import com.bastet.bastetmanagement.dtos.selectdtos.SocialActivityTypeSelectElementDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.SocialActivityTypeSimplifiedDto;
import com.bastet.bastetmanagement.facades.socialactivitytype.SocialActivityTypeFacade;
import com.bastet.bastetmanagement.mappers.SocialActivityTypeMapper;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.SocialActivityType;
import com.bastet.bastetmanagement.models.SocialActivityType;
import com.bastet.bastetmanagement.services.socialactivitytype.SocialActivityTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class SocialActivityTypeFacadeImpl implements SocialActivityTypeFacade {

    @Resource
    private SocialActivityTypeService socialActivityTypeService;

    @Resource
    private SocialActivityTypeMapper socialActivityTypeMapper;

    @Override
    public SocialActivityTypeDto findById(UUID id) {
        return socialActivityTypeMapper.socialActivityTypeToSocialActivityTypeDto(socialActivityTypeService.findById(id));
    }

    @Override
    public SocialActivityTypeSimplifiedDto findByIdSimplified(UUID id) {
        return socialActivityTypeMapper.socialActivityTypeToSocialActivityTypeSimplifiedDto(socialActivityTypeService.findById(id));
    }

    @Override
    public Page<SocialActivityTypeDto> findAllPaged(Pageable pageable) {
        return socialActivityTypeService.findAllPaged(pageable).map(socialActivityType -> socialActivityTypeMapper.socialActivityTypeToSocialActivityTypeDto(socialActivityType));
    }

    @Override
    public Page<SocialActivityTypeSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return socialActivityTypeService.findAllPaged(pageable).map(socialActivityType -> socialActivityTypeMapper.socialActivityTypeToSocialActivityTypeSimplifiedDto(socialActivityType));
    }

    @Override
    public List<SocialActivityTypeSelectElementDto> findAllForSelectElement(){
        List<SocialActivityType> socialActivityTypes = socialActivityTypeService.findAll();
        return socialActivityTypeMapper.SocialActivityTypeListToSocialActivityTypeSelectElementDtoList(socialActivityTypes);
    }

    @Override
    public boolean add(Dto dto) {
        SocialActivityType socialActivityType = socialActivityTypeMapper.socialActivityTypeDtoToSocialActivityType((SocialActivityTypeDto) dto);
        boolean success = socialActivityTypeService.add(socialActivityType);
        return success;
    }
    @Override
    public boolean deleteById(UUID id) {
        return socialActivityTypeService.deleteById(id);
    }
}
