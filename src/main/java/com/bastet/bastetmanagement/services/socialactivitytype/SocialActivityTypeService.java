package com.bastet.bastetmanagement.services.socialactivitytype;

import com.bastet.bastetmanagement.models.SocialActivityType;

import java.util.UUID;

public interface SocialActivityTypeService {
    SocialActivityType findById(UUID id);
}
