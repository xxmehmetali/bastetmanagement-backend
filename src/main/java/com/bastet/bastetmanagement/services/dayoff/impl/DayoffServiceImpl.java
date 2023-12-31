package com.bastet.bastetmanagement.services.dayoff.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.core.utilities.results.ResultUtil;
import com.bastet.bastetmanagement.daos.DayOffDao;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Dayoff;
import com.bastet.bastetmanagement.services.cv.CvService;
import com.bastet.bastetmanagement.services.dayoff.DayoffService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class DayoffServiceImpl implements DayoffService {
    @Resource
    private DayOffDao dayOffDao;
    @Override
    public Dayoff findById(UUID id){
        return dayOffDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Dayoff not found."));
    }

    @Override
    public Page<Dayoff> findAllPaged(Pageable pageable) {
        return dayOffDao.findAll(pageable);
    }

    @Override
    public List<Dayoff> findAll() {
        return dayOffDao.findAll();
    }

    @Override
    public boolean add(Dayoff dayoff) {
        return ResultUtil.extractSuccess(dayOffDao.save(dayoff));
    }
    @Override
    public boolean deleteById(UUID id) {
        dayOffDao.deleteById(id);
        return ! dayOffDao.existsById(id);
    }
}
