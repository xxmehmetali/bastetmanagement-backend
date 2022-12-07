package com.bastet.bastetmanagement.services.applicant.impl;

import com.bastet.bastetmanagement.daos.ApplicantDao;
import com.bastet.bastetmanagement.models.Applicant;
import com.bastet.bastetmanagement.services.applicant.ApplicantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Resource
    private ApplicantDao applicantDao;

    private Applicant findById(UUID id){
        Applicant applicants = applicantDao.findById(id).orElse(null);
        return applicants;
    }

}
