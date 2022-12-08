package com.bastet.bastetmanagement.facades.dayoff.impl;

import com.bastet.bastetmanagement.dtos.basedtos.DayoffDto;
import com.bastet.bastetmanagement.facades.dayoff.DayoffFacade;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DayoffFacadeImpl implements DayoffFacade {
    @Override
    public DayoffDto findById(UUID id) {
        return null;
    }
}
