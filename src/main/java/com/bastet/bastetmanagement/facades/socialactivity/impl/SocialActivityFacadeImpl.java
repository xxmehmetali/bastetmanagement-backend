package com.bastet.bastetmanagement.facades.socialactivity.impl;


import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.SocialActivitySimplifiedDto;
import com.bastet.bastetmanagement.facades.socialactivity.SocialActivityFacade;
import com.bastet.bastetmanagement.services.socialactivity.SocialActivityService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class SocialActivityFacadeImpl implements SocialActivityFacade {

    @Resource
    private SocialActivityService socialActivityService;


    @Override
    public SocialActivityDto findById(UUID id) {
        return null;
    }

    @Override
    public SocialActivitySimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }

}
