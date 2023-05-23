package com.bastet.bastetmanagement.services.context.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.core.utilities.results.ResultUtil;
import com.bastet.bastetmanagement.daos.ContextDao;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.models.Context;
import com.bastet.bastetmanagement.services.context.ContextService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class ContextServiceImpl implements ContextService {

    @Resource
    private ContextDao contextDao;

    @Override
    public Context findById(UUID id){
        return contextDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Context not found."));
    }

    @Override
    public Page<Context> findAllPaged(Pageable pageable) {
        return contextDao.findAll(pageable);
    }

    @Override
    public List<Context> findAll() {
        return contextDao.findAll();
    }

    @Override
    public boolean add(Context context) {
        return ResultUtil.extractSuccess(contextDao.save(context));
    }

    @Override
    public boolean deleteById(UUID id) {
        contextDao.deleteById(id);
        return ! contextDao.existsById(id);
    }
}
