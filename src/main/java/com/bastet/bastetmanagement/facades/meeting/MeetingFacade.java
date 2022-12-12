package com.bastet.bastetmanagement.facades.meeting;

import com.bastet.bastetmanagement.dtos.basedtos.MeetingDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingSimplifiedDto;

import java.util.UUID;

public interface MeetingFacade {
    MeetingDto findById(UUID id);
    MeetingSimplifiedDto findByIdSimplified(UUID id);
}
