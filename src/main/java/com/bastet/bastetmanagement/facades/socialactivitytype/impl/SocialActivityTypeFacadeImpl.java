package com.bastet.bastetmanagement.facades.socialactivitytype.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityTypeDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.SocialActivityTypeSimplifiedDto;
import com.bastet.bastetmanagement.facades.socialactivitytype.SocialActivityTypeFacade;
import com.bastet.bastetmanagement.mappers.SocialActivityTypeMapper;
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
        return null;
    }

    @Override
    public SocialActivityTypeSimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }

    @Override
    public Page<SocialActivityTypeDto> findAllPaged(Pageable pageable) {
        Page pageImpl = socialActivityTypeService.findAllPaged(pageable);
        List<SocialActivityTypeDto> dtos = socialActivityTypeMapper.socialActivityTypeListToSocialActivityTypeDtoList(pageImpl.getContent());
        return new PageImpl<>(dtos, pageable, pageImpl.getTotalPages());

    }

    @Override
    public Page<SocialActivityTypeSimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return null;
    }
}
