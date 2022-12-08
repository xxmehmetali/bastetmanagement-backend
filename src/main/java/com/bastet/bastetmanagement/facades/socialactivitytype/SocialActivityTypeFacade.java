package com.bastet.bastetmanagement.facades.socialactivitytype;

import com.bastet.bastetmanagement.dtos.basedtos.SocialActivityTypeDto;

import java.util.UUID;

public interface SocialActivityTypeFacade {
    SocialActivityTypeDto findById(UUID id);
}
