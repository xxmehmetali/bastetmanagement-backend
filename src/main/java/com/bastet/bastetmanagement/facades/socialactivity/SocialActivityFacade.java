package com.bastet.bastetmanagement.facades.socialactivity;

import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.SocialActivitySimplifiedDto;

import java.util.UUID;

public interface SocialActivityFacade {
    SocialActivityDto findById(UUID id);
    SocialActivitySimplifiedDto findByIdSimplified(UUID id);
}
