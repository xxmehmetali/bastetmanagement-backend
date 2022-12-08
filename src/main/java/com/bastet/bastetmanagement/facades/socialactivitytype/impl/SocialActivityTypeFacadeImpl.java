package com.bastet.bastetmanagement.facades.socialactivitytype.impl;

import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityTypeDto;
import com.bastet.bastetmanagement.facades.socialactivitytype.SocialActivityTypeFacade;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SocialActivityTypeFacadeImpl implements SocialActivityTypeFacade {
    @Override
    public SocialActivityTypeDto findById(UUID id) {
        return null;
    }
}
