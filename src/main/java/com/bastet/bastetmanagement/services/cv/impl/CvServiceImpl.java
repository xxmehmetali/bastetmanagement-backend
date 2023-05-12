package com.bastet.bastetmanagement.services.cv.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.core.utilities.results.ResultUtil;
import com.bastet.bastetmanagement.daos.CvDao;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Cv;
import com.bastet.bastetmanagement.services.cv.CvService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class CvServiceImpl implements CvService {
    @Resource
    CvDao cvDao;

    public Cv findById(UUID id){
        return cvDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Cv not found."));
    }

    @Override
    public Page<Cv> findAllPaged(Pageable pageable) {
        return cvDao.findAll(pageable);
    }

    @Override
    public List<Cv> findAll() {
        return cvDao.findAll();
    }

    @Override
    public boolean add(Cv cv) {
        return ResultUtil.extractSuccess(cvDao.save(cv));
    }
}
