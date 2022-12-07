package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.daos.MeetingPlatformDao;
import com.bastet.bastetmanagement.models.MeetingPlatform;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/meetingPlatform")
public class MeetingPlatformController {

    @Resource
    private MeetingPlatformDao meetingPlatformDao;

    @GetMapping("/getAll")
    public List<MeetingPlatform> getAll(){
        return meetingPlatformDao.findAll();
    }

    @GetMapping("/findById/{id}")
    public MeetingPlatform findById(@PathVariable("id") UUID id){
        return meetingPlatformDao.findById(id).orElse(null);
    }
}
