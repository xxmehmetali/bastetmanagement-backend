package com.bastet.bastetmanagement.services.corporation;

import com.bastet.bastetmanagement.models.Corporation;

import java.util.UUID;

public interface CorporationService {
    Corporation findById(UUID id);
}
