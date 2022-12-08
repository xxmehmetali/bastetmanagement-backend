package com.bastet.bastetmanagement.facades.context.impl;

import com.bastet.bastetmanagement.dtos.basedtos.ContextDto;
import com.bastet.bastetmanagement.facades.context.ContextFacade;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ContextFacadeImpl implements ContextFacade {
    @Override
    public ContextDto findById(UUID id) {
        return null;
    }
}
