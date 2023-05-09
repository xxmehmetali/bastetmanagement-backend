package com.bastet.bastetmanagement.services.occupation.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.daos.OccupationDao;
import com.bastet.bastetmanagement.models.Occupation;
import com.bastet.bastetmanagement.services.occupation.OccupationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2

public class OccupationServiceImpl implements OccupationService {
    @Resource
    private OccupationDao occupationDao;

    @Override
    public Occupation findById(UUID id) {
        return occupationDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Occupation not found."));
    }

    @Override
    public Page<Occupation> findAllPaged(Pageable pageable) {
        return occupationDao.findAll(pageable);
    }

    @Override
    public List<Occupation> findAll() {
        return occupationDao.findAll();
    }
}
