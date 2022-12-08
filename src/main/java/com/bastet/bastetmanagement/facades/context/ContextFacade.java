package com.bastet.bastetmanagement.facades.context;

import com.bastet.bastetmanagement.daos.ContextDao;
import com.bastet.bastetmanagement.dtos.basedtos.ContextDto;

import java.util.UUID;

public interface ContextFacade {
    ContextDto findById(UUID id);
}
