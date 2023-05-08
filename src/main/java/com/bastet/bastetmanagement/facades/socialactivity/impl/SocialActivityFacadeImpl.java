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
        return socialActivityMapper.socialActivityToSocialActivityDto(socialActivityService.findById(id));
    }

    @Override
    public SocialActivitySimplifiedDto findByIdSimplified(UUID id) {
        return socialActivityMapper.socialActivityToSocialActivitySimplifiedDto(socialActivityService.findById(id));
    }

    @Override
    public Page<SocialActivityDto> findAllPaged(Pageable pageable) {
        return socialActivityService.findAllPaged(pageable).map(socialActivity -> socialActivityMapper.socialActivityToSocialActivityDto(socialActivity));
    }

    @Override
    public Page<SocialActivitySimplifiedDto> findAllPagedSimplified(Pageable pageable) {
        return socialActivityService.findAllPaged(pageable).map(socialActivity -> socialActivityMapper.socialActivityToSocialActivitySimplifiedDto(socialActivity));
    }

    @Override
    public List<? extends Dto> findAllForSelectElement() {
        return null;
    }
}
