package com.bastet.bastetmanagement.facades.socialactivitytype.impl;


import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityTypeDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.SocialActivityTypeSimplifiedDto;
import com.bastet.bastetmanagement.facades.socialactivitytype.SocialActivityTypeFacade;
import com.bastet.bastetmanagement.services.socialactivitytype.SocialActivityTypeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class SocialActivityTypeFacadeImpl implements SocialActivityTypeFacade {



    @Resource
    private SocialActivityTypeService socialActivityTypeService;

    @Override
    public SocialActivityTypeDto findById(UUID id) {
        return null;
    }

    @Override
    public SocialActivityTypeSimplifiedDto findByIdSimplified(UUID id) {
        return null;
    }


}
