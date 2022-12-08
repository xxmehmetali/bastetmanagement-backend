package com.bastet.bastetmanagement.facades.meeting;

import com.bastet.bastetmanagement.dtos.basedtos.MeetingDto;

import java.util.UUID;

public interface MeetingFacade {
    MeetingDto findById(UUID id);
}
