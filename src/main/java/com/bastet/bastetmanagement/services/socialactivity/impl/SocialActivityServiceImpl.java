package com.bastet.bastetmanagement.services.socialactivity.impl;

import com.bastet.bastetmanagement.daos.SocialActivityDao;
import com.bastet.bastetmanagement.models.SocialActivity;
import com.bastet.bastetmanagement.services.socialactivity.SocialActivityService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Log4j2
public class SocialActivityServiceImpl implements SocialActivityService {

    @Resource
    private SocialActivityDao socialActivityDao;

    @Override
    public SocialActivity findById(UUID id) {
        SocialActivity socialActivity=socialActivityDao.findById(id).orElse(null);
        return socialActivity;
    }

    @Override
    public Page<SocialActivity> findAllPaged(Pageable pageable) {
        return null;
    }
}
