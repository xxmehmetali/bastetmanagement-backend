package com.bastet.bastetmanagement.services.applicant.impl;

import com.bastet.bastetmanagement.core.customexceptions.ModelNotFoundException;
import com.bastet.bastetmanagement.core.utilities.results.ResultUtil;
import com.bastet.bastetmanagement.daos.ApplicantDao;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.services.applicant.ApplicantService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Log4j2
public class ApplicantServiceImpl implements ApplicantService {

    @Resource
    private ApplicantDao applicantDao;

    @Override
    public Applicant findById(UUID id) {
        return applicantDao.findById(id).orElseThrow(() -> new ModelNotFoundException("Applicant not found"));
    }

    @Override
    public Page<Applicant> findAllPaged(Pageable pageable) {
        return applicantDao.findAll(pageable);
    }

    @Override
    public List<Applicant> findAll() {
        return applicantDao.findAll();
    }

    @Override
    public boolean add(Applicant applicant) {

        return ResultUtil.extractSuccess(applicantDao.save(applicant));
    }

    @Override
    public boolean deleteById(UUID id) {
        applicantDao.deleteById(id);
        return ! applicantDao.existsById(id);
    }
}
