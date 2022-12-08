package com.bastet.bastetmanagement.services.corporation.impl;

import com.bastet.bastetmanagement.daos.CorporationDao;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.services.corporation.CorporationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Log4j2
public class CorporationServiceImpl implements CorporationService {

    @Resource
    private CorporationDao corporationDao;
    @Override
    public Corporation findById(UUID id){
        Corporation corporation = corporationDao.findById(id).orElse(null);
        return corporation;
    }
}
