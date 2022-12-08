package com.bastet.bastetmanagement.services.socialactivity;

import com.bastet.bastetmanagement.models.SocialActivity;

import java.util.UUID;

public interface SocialActivityService {
    SocialActivity findById(UUID id);
}
