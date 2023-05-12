package com.bastet.bastetmanagement.services.socialactivitytype.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.core.utilities.results.ResultUtil;
import com.bastet.bastetmanagement.daos.SocialActivityDao;
import com.bastet.bastetmanagement.daos.SocialActivityTypeDao;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.SocialActivityType;
import com.bastet.bastetmanagement.services.socialactivitytype.SocialActivityTypeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2

public class SocialActivityTypeServiceImpl implements SocialActivityTypeService {

    @Resource
    private SocialActivityTypeDao socialActivityTypeDao;

    @Override
    public SocialActivityType findById(UUID id) {
        return socialActivityTypeDao.findById(id).orElseThrow(() -> new ModelNotFoundException("SocialActivityType not found."));
    }

    @Override
    public Page<SocialActivityType> findAllPaged(Pageable pageable) {
        return socialActivityTypeDao.findAll(pageable);
    }

    @Override
    public List<SocialActivityType> findAll() {
        return socialActivityTypeDao.findAll();
    }

    @Override
    public boolean add(SocialActivityType socialActivityType) {
        return ResultUtil.extractSuccess(socialActivityTypeDao.save(socialActivityType));
    }
}
