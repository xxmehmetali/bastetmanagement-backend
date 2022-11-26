package com.bastet.bastetmanagement.services.cv.impl;

import com.bastet.bastetmanagement.daos.CvDao;
import com.bastet.bastetmanagement.models.Cv;
import com.bastet.bastetmanagement.services.cv.CvService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class CvServiceImpl implements CvService {
    @Resource
    CvDao cvDao;

    @Override
    public List<Cv> findAll() {
        return cvDao.findAll();
    }

    public Cv findById(UUID id){
        return cvDao.findById(id).orElse(null);
    }
}
