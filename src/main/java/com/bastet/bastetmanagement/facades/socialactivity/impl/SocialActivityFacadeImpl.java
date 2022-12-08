package com.bastet.bastetmanagement.facades.socialactivity.impl;

import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityDto;
import com.bastet.bastetmanagement.facades.socialactivity.SocialActivityFacade;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SocialActivityFacadeImpl implements SocialActivityFacade {
    @Override
    public SocialActivityDto findById(UUID id) {
        return null;
    }
}
