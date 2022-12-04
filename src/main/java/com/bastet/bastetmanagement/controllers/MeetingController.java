package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.daos.MeetingDao;
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

    @GetMapping("/findById/{id}")
    public Meeting findById(@PathVariable("id")UUID id){
        return meetingDao.findById(id).orElse(null);
    }
}
