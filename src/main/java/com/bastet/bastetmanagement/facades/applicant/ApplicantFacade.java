package com.bastet.bastetmanagement.facades.applicant;

import com.bastet.bastetmanagement.daos.ApplicantDao;
import com.bastet.bastetmanagement.dtos.basedtos.ApplicantDto;
import com.bastet.bastetmanagement.dtos.simplifieddtos.ApplicantSimplifiedDto;
import com.bastet.bastetmanagement.models.Applicant;

import java.util.UUID;

public interface ApplicantFacade {
    ApplicantDto findById(UUID id);

    ApplicantSimplifiedDto findByIdSimplified(UUID id);
}