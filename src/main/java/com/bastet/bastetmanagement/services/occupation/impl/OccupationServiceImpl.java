package com.bastet.bastetmanagement.services.occupation.impl;

import com.bastet.bastetmanagement.daos.OccupationDao;
import com.bastet.bastetmanagement.models.Occupation;
import com.bastet.bastetmanagement.services.occupation.OccupationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Log4j2

public class OccupationServiceImpl implements OccupationService {
    @Resource
    private OccupationDao occupationDao;

    @Override
    public Occupation findById(UUID id) {
        Occupation occupation=occupationDao.findById(id).orElse(null);
        return occupation;
    }
}
