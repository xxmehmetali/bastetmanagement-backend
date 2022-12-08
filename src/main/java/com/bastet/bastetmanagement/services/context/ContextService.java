package com.bastet.bastetmanagement.services.context;

import com.bastet.bastetmanagement.models.Context;

import java.util.UUID;

public interface ContextService {
    Context findById(UUID id);
}
