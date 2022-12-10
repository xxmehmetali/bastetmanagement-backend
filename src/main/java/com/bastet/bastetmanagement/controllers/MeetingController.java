package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.core.configurations.modelmapper.CustomModelMapper;
import com.bastet.bastetmanagement.daos.MeetingDao;
import com.bastet.bastetmanagement.dtos.basedtos.MeetingDto;
import com.bastet.bastetmanagement.models.Meeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Resource
    private MeetingDao meetingDao;
    @Resource
    private CustomModelMapper customModelMapper;
    @GetMapping("/findById/{id}")
    public MeetingDto findById(@PathVariable("id")UUID id){
        return customModelMapper.map(meetingDao.findById(id).orElse(null), MeetingDto.class);
    }
}
