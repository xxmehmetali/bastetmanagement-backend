package com.bastet.bastetmanagement.facades.socialactivity.impl;


import com.bastet.bastetmanagement.dtos.Dto;
import com.bastet.bastetmanagement.dtos.basedtos.DepartmentDto;
import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.SocialActivitySimplifiedDto;
import com.bastet.bastetmanagement.facades.socialactivity.SocialActivityFacade;
import com.bastet.bastetmanagement.mappers.SocialActivityMapper;
import com.bastet.bastetmanagement.services.socialactivity.SocialActivityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class SocialActivityFacadeImpl implements SocialActivityFacade {

    @Resource
    private SocialActivityService socialActivityService;

    @Resource
    private SocialActivityMapper socialActivityMapper;

    @Override
    public SocialActivityDto findById(UUID id) {
        return null;
    }

    @Override
    public SocialActivitySimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }

    @Override
    public Page<SocialActivityDto> findAllPaged(Pageable pageable) {
        Page pageImpl = socialActivityService.findAllPaged(pageable);
        List<SocialActivityDto> dtos = socialActivityMapper.socialActivityListToSocialActivityDtoList(pageImpl.getContent());
        return new PageImpl<>(dtos, pageable, pageImpl.getTotalPages());

    }

    @Override
    public Page<SocialActivitySimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return null;
    }
}
