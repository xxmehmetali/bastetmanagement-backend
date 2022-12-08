package com.bastet.bastetmanagement.services.applicant.impl;

import com.bastet.bastetmanagement.daos.ApplicantDao;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.services.applicant.ApplicantService;
import lombok.extern.log4j.Log4j2;
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
    public Applicant findById(UUID id){
        Applicant applicant = applicantDao.findById(id).orElse(null);
        return applicant;
    }

}
