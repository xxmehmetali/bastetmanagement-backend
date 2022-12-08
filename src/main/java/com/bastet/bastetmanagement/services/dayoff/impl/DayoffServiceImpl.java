package com.bastet.bastetmanagement.services.dayoff.impl;

import com.bastet.bastetmanagement.daos.DayOffDao;
import com.bastet.bastetmanagement.models.Dayoff;
import com.bastet.bastetmanagement.services.cv.CvService;
import com.bastet.bastetmanagement.services.dayoff.DayoffService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Log4j2
public class DayoffServiceImpl implements DayoffService {
    @Resource
    private DayOffDao dayOffDao;
    @Override
    public Dayoff findById(UUID id){
        Dayoff dayoff = dayOffDao.findById(id).orElse(null);
        return dayoff;
    }

}
