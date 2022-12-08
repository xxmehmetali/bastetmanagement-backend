package com.bastet.bastetmanagement.services.occupation;

import com.bastet.bastetmanagement.models.Occupation;

import java.util.UUID;

public interface OccupationService {
    Occupation findById(UUID id);
}
