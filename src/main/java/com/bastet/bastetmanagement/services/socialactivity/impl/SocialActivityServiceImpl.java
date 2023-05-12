package com.bastet.bastetmanagement.services.socialactivity.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.core.utilities.results.ResultUtil;
import com.bastet.bastetmanagement.daos.SocialActivityDao;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.SocialActivity;
import com.bastet.bastetmanagement.services.socialactivity.SocialActivityService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class SocialActivityServiceImpl implements SocialActivityService {

    @Resource
    private SocialActivityDao socialActivityDao;

    @Override
    public SocialActivity findById(UUID id) {
        return socialActivityDao.findById(id).orElseThrow(() -> new ModelNotFoundException("SocialActivity not found."));
    }

    @Override
    public Page<SocialActivity> findAllPaged(Pageable pageable) {
        return socialActivityDao.findAll(pageable);
    }

    @Override
    public List<SocialActivity> findAll() {
        return socialActivityDao.findAll();
    }

    @Override
    public boolean add(SocialActivity socialActivity) {
        return ResultUtil.extractSuccess(socialActivityDao.save(socialActivity));
    }
}
