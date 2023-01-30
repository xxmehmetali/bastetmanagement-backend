package com.bastet.bastetmanagement.services.meeting;

import com.bastet.bastetmanagement.dtos.basedtos.MeetingDto;
import com.bastet.bastetmanagement.models.Meeting;
import com.bastet.bastetmanagement.services.GenericService;

import java.util.UUID;

public interface MeetingService extends GenericService<Meeting> {
    Meeting findById(UUID id);
}
