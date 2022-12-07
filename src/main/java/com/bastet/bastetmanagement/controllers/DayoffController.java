package com.bastet.bastetmanagement.controllers;

import com.bastet.bastetmanagement.daos.DayOffDao;
import com.bastet.bastetmanagement.models.Dayoff;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/dayoff")
public class DayoffController {

    @Resource
    private DayOffDao dayOffDao;

    @GetMapping("/findById/{id}")
    public Dayoff findById(@PathVariable("id")UUID id){
        return dayOffDao.findById(id).orElse(null);
    }
}
