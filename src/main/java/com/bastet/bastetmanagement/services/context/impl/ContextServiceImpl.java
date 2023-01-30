package com.bastet.bastetmanagement.services.context.impl;

import com.bastet.bastetmanagement.daos.ContextDao;
import com.bastet.bastetmanagement.models.Context;
import com.bastet.bastetmanagement.services.context.ContextService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Log4j2
public class ContextServiceImpl implements ContextService {

    @Resource
    private ContextDao contextDao;

    @Override
    public Page<Context> findAllPaged(Pageable pageable) {
        return null;
    }

    @Override
    public Context findById(UUID id){
        Context context = contextDao.findById(id).orElse(null);
        return context;
    }
}
