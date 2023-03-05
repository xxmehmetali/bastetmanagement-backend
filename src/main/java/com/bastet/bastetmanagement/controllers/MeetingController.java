package com.bastet.bastetmanagement.controllers;


import com.bastet.bastetmanagement.daos.MeetingDao;
import com.bastet.bastetmanagement.dtos.basedtos.MeetingDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingPlatformSimplifiedDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.MeetingSimplifiedDto;
import com.bastet.bastetmanagement.facades.meeting.MeetingFacade;
import com.bastet.bastetmanagement.facades.meetingplatform.MeetingPlatformFacade;
import com.bastet.bastetmanagement.models.Meeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/meeting")
public class MeetingController extends BaseController {
    @Resource
    private MeetingFacade meetingFacade;

    @GetMapping("/findById/{id}")
    public MeetingDto findById(@PathVariable("id")UUID id){
        return null;
    }
    @GetMapping("/simplified/findById/{id}")
    public MeetingSimplifiedDto findByIdSimplified(@PathVariable("id") UUID id){
        return meetingFacade.findByIdSimplified(id);
    }

}
