package com.bastet.bastetmanagement.services.applicant;

import com.bastet.bastetmanagement.models.Applicant;

import java.util.UUID;

public interface ApplicantService {
    Applicant findById(UUID id);
}
