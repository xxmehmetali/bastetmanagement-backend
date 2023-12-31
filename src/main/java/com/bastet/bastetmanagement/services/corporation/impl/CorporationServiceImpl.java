package com.bastet.bastetmanagement.services.corporation.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.core.utilities.results.ResultUtil;
import com.bastet.bastetmanagement.daos.CorporationDao;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.services.corporation.CorporationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class CorporationServiceImpl implements CorporationService {


    @Resource
    private CorporationDao corporationDao;

    @Override
    public Corporation findById(UUID id) {
        return corporationDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Corporation not found."));
    }

    @Override
    public Page<Corporation> findAllPaged(Pageable pageable) {
        return corporationDao.findAll(pageable);
    }


    @Override
    public boolean add(Corporation corporation) {
        return ResultUtil.extractSuccess(corporationDao.save(corporation));
    }

    @Override
    public List<Corporation> findAll() {
        return corporationDao.findAll();
    }

    @Override
    public boolean deleteById(UUID id) {
        corporationDao.deleteById(id);
        return ! corporationDao.existsById(id);
    }
}
