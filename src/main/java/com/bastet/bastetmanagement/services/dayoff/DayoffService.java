package com.bastet.bastetmanagement.services.dayoff;

import com.bastet.bastetmanagement.models.Dayoff;

import java.util.UUID;

public interface DayoffService {
    Dayoff findById(UUID id);
}
